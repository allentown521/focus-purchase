/**
 * Copyright (C) 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package allen.town.focus_purchase.iap

import allen.town.core.service.GooglePayService
import allen.town.focus.reader.iap.Security
import allen.town.focus_purchase.iap.BillingRepository.SubSku.CONSUMABLE_SKUS
import allen.town.focus_purchase.iap.BillingRepository.SubSku.INAPP_SKUS
import allen.town.focus_purchase.iap.BillingRepository.SubSku.SUBS_SKUS
import allen.town.focus_common.util.Timber
import allen.town.focus_purchase.MyBaseApp
import allen.town.focus_purchase.iap.util.IabResult
import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.android.billingclient.api.*
import com.wyjson.router.GoRouter
import kotlinx.coroutines.*
import rx.Subscriber
import java.util.*

/**
 *
 * FOREWORD:
 *
 * To avoid ambiguity and for simplified readability:
 *
 *  - the term "user" shall refer to people who download the app and buy
 *    products or subscriptions.
 *
 *  - the term "client" shall refer to those developers/engineers on the team who depend on the
 *    billing repository as an API.
 *
 * GOVERNING ARCHITECTURE:
 *
 * A Google Play Billing implementation depends on purchase confirmation data from three different
 * data sources: the Google Play Billing service, a secure server, and the app's own local cache.
 * A repository module is needed to manage these different data sources and associated operations
 * so that the rest of the app can access this data. Let this module be called [BillingRepository].
 * And this module shall handle all interactions with the
 * _Play Billing Library_, the billing portions of a secure server, and the billing portions of
 * the app’s local cache.
 *
 * What the rest of the app gets, then, is an API in the form of a ViewModel that comprises:
 * a list of inventory (i.e. what’s for sale); a purchase function (i.e. how to buy); and a set
 * of entitlements (i.e. what the user owns). This recommended structure removes some of the
 * complexities of Google Play Billing. Managed products, consumable products, subscriptions, and
 * other product types are handled identically through a unified API.
 *
 * What this also means is that all of the work is now concentrated in one module, the
 * [BillingRepository]. This repository shall track everything the app is selling and how the app
 * is selling them. The app should not be selling anything that's not listed in this
 * repository. Therefore, the engineers responsible for implementing the [BillingRepository]
 * need to fully understand the app's business model.
 *
 * Figure 1 shows the app from the perspective of the billing module.
 *
 * ```
 *    _____________
 *  _|___________  |     _____________       _____________     __________________________
 * |             | |    |             |     |             |  /|Secure Server Billing Data|
 * |  Activity   | |    | ViewModel   |     | Billing     | /  --------------------------
 * |     &       | |    |    Set      |     | Repository  |/   ________________________
 * |  Fragment   | |--->|             |---->|             |---|Local Cache Billing Data|
 * |    Set      | |    |             |     |             |    ------------------------
 * |             | |    |             |     |             |    _________________
 * |             | |    |             |     |             |---|Play Billing Data|
 * |             |_|    |             |     |             |    -----------------
 * |_____________|      |_____________|     |_____________|
 *
 *  Figure 1
 * ```
 *
 * DATA DYNAMICS:
 *
 * It’s important to consider data mechanics when designing a feature as crucial as the
 * app’s billing repository. Where the billing data rests and how it flows through the repository
 * are central aspects of the design.
 *
 * The Google Play Billing Library 2.0 and above (PBL 2.0+) enables us to draw sharp distinction
 * amongst three primary implementations of billing:
 *
 * 1- Billing integration with no offline access to entitlements
 *
 * 2- Server-reliant billing integration with offline access to some entitlements
 *
 * 3- Serverless billing integration
 *
 * While these three primary integrations do have possible combined derivatives, in the coming
 * weeks we will provide samples or codelabs that address each of these primary integrations.
 *
 * The following three figures depict each model:
 *
 *
 * ```
 * Figure 2 -- Billing integration with no offline access to entitlements
 *
 *  _____                        _________________
 * |Start|----------------------|launchBillingFlow|
 *  -----                        -----------------
 *                                        |
 *                                  ______v____________
 *                                 |onPurchasesUpdated |
 *                                  -------------------
 *                                 /      |
 *                   ITEM_ALREADY_OWNED   |
 *                               /        |
 *  _____       ________________v__       |
 * |Start|-----|queryPurchasesAsync|      OK
 *  -----       -------------------       |
 *                               \        |
 *                               v________v_______
 *                              |processPurchases |
 *                               -----------------
 *                                        |
 *                                        |
 *                                 _______v__________
 *                                | ? isConsumable?  |
 *                                 ------------------
 *                                      |
 *                                      |
 *                                     / \
 *                                 yes/   \
 *                ___________________v_    \
 *               |[processConsumables]|     \
 *                --------------------       \
 *                             |              \
 *                             |               \
 *                             v_______________v________
 *                            |     REMOTE SERVER:      |
 *                            | - verify purchases      |
 *                            | - disburse entitlements |
 *                             -------------------------
 *                                        |
 *                                  ______v____
 *                                 |  LiveData |
 *                                  -----------
 *                                        |
 *                         _______________v_____________________
 *                        |  API / Client Interface / ViewModel |
 *                        ---------------------------------------
 *
 * ```
 *
 *
 * ```
 * Figure 3 -- Server-reliant billing integration with offline access to some entitlements
 *
 *  _____                        _________________
 * |Start|----------------------|launchBillingFlow|
 *  -----                        -----------------
 *                                        |
 *                                  ______v____________
 *                                 |onPurchasesUpdated |
 *                                  -------------------
 *                                 /      |
 *                   ITEM_ALREADY_OWNED   |
 *                               /        |
 *  _____       ________________v__       |
 * |Start|-----|queryPurchasesAsync|      OK
 *  -----       -------------------       |
 *                               \        |
 *                               v________v_______
 *                              |processPurchases |
 *                               -----------------
 *                                        |
 *                                        |
 *                                 _______v__________
 *                                | ? isConsumable?  |
 *                                 ------------------
 *                                      |
 *                                      |
 *                                     / \
 *                                 yes/   \
 *                ___________________v_    \
 *               |[processConsumables]|     \
 *                --------------------       \
 *                             |              \
 *                             |               \
 *                             v_______________v________
 *                            |     REMOTE SERVER:      |
 *                            | - verify purchases      |
 *                            | - disburse entitlements |
 *                             -------------------------
 *                                        |
 *                                        |
 *                                 _______v________
 *                                | local database |
 *                                 ----------------
 *                                        |
 *                                  ______v____
 *                                 |  LiveData |
 *                                  -----------
 *                                        |
 *                         _______________v_____________________
 *                        |  API / Client Interface / ViewModel |
 *                        ---------------------------------------
 *
 * ```
 *
 *
 * ```
 * Figure 4 -- Serverless billing integration
 *
 *  _____                        _________________
 * |Start|----------------------|launchBillingFlow|
 *  -----                        -----------------
 *                                        |
 *                                  ______v____________
 *                                 |onPurchasesUpdated |
 *                                  -------------------
 *                                 /      |
 *                   ITEM_ALREADY_OWNED   |
 *                               /        |
 *  _____       ________________v__       |
 * |Start|-----|queryPurchasesAsync|      OK
 *  -----       -------------------       |
 *                               \        |
 *                               v________v_______
 *                              |processPurchases |
 *                               -----------------
 *                                        |
 *                                        |
 *                                 _______v__________
 *                                | ? isConsumable?  |
 *                                 ------------------
 *                                 |           |
 *                                 |           |
 *                                 |        ___v___________________
 *                                 |       |  acknowledge purchase |
 *                              yes|        -----------------------
 *                _________________v__         |
 *               | processConsumables |        |
 *                --------------------         |
 *                             |               |
 *                             |               |
 *                             v_______________v________
 *                            |  disburse entitlements |
 *                             -------------------------
 *                                        |
 *                                        |
 *                                 _______v________
 *                                | local database |
 *                                 ----------------
 *                                        |
 *                                  ______v____
 *                                 |  LiveData |
 *                                  -----------
 *                                        |
 *                         _______________v_____________________
 *                        |  API / Client Interface / ViewModel |
 *                        ---------------------------------------
 *
 *
 * ```
 *
 * Figures 2 and 3 process the purchases and disburse the entitlements on the remote server. But
 * Figure 4, being serverless, processes everything inside the Android app. This present sample
 * will follow the flow depicted in Figure 4.
 *
 * Here is a bit more detail on the flow depicted in Figure 4:
 *
 * 1. [launchBillingFlow] and [queryPurchasesAsync] can be called directly from the client:
 *   [launchBillingFlow] may be triggered by a button click when the user wants to buy something;
 *   [queryPurchasesAsync] may be triggered when the app launches, by a pull-to-refresh or an
 *   [Activity] lifecycle event. Hence, they are the starting points in the process.
 *
 * 2. [onPurchasesUpdated] is the callback that the Play [BillingClient] calls in response to its
 *    [launchBillingFlow][BillingClient.launchBillingFlow] being called. If the response code is
 *    [BillingClient.BillingResponseCode.OK], then developers may go straight to [processPurchases]. If, however, the
 *    response code is [BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED], then developers should call
 *    [queryPurchasesAsync] to verify if other such already-owned items exist that should be
 *    processed.
 *
 * 3. The [queryPurchasesAsync] method grabs all the active purchases of this user and makes them
 *    available to this app instance. Calling Play's [BillingClient] multiple times is relatively
 *    cheap; it involves no network calls since Play stores the data in its own local cache. The
 *    purchase data is then [processed][processPurchases] and converted to
 *    [premium contents][Entitlement].
 *
 * 4. Finally, all data that end up as part of the public interface of the [BillingRepository]
 *    (i.e. in the [BillingViewModel]), and therefore in other portions of the app, come immediately
 *    from the local cache billing client. The local cache is backed by a [Room] database and all
 *    the data visible to the clients is wrapped in [LiveData] so that changes are reflected in
 *    the clients as soon as they happen.
 *
 *
 * ```
 *
 * FINAL THOUGHT
 *
 * We strongly recommend that you implement Figure 3 or Figure 2 in your app. However, the
 * implementation for Figure 4 is provided for apps that do not already have a server component
 * and do not wish to create one just for Google Play Billing.
 *
 * While the architecture presented here and most of the code is highly reusable, this repository
 * is app-specific. For Trivial Drive, for example, it is tailored to sell three items: a premium
 * car, gas for driving, and gold status. Consequently, this repo must handle logic that
 * deals with what it means for a user to own a premium car or buy gas.
 *
 *  @param application the [Application] context
 */
class BillingRepository :
    PurchasesUpdatedListener, BillingClientStateListener {

    /**
     * The [BillingClient] is the most reliable and primary source of truth for all purchases
     * made through the Google Play Store. The Play Store takes security precautions in guarding
     * the data. Also, the data is available offline in most cases, which means the app incurs no
     * network charges for checking for purchases using the [BillingClient]. The offline bit is
     * because the Play Store caches every purchase the user owns, in an
     * [eventually consistent manner](https://developer.android.com/google/play/billing/billing_library_overview#Keep-up-to-date).
     * This is the only billing client an app is actually required to have on Android. The other
     * two (webServerBillingClient and localCacheBillingClient) are optional.
     *
     * ASIDE. Notice that the connection to [playStoreBillingClient] is created using the
     * applicationContext. This means the instance is not [Activity]-specific. And since it's also
     * not expensive, it can remain open for the life of the entire [Application]. So whether it is
     * (re)created for each [Activity] or [Fragment] or is kept open for the life of the application
     * is a matter of choice.
     */
    private var playStoreBillingClient: BillingClient

    // Context we were passed during initialization
    var mContext: Context? = null
        get() = field

    private lateinit var setupFinishedListener: OnIabSetupFinishedListener

    constructor(ctx: Context) {
        mContext = ctx.applicationContext
        playStoreBillingClient = BillingClient.newBuilder(ctx)
            .enablePendingPurchases() // required or app will crash
            .setListener(this).build()
        Log.d(LOG_TAG, "IAB helper created")
    }
    // END list of each distinct item user may own (i.e. entitlements)

    fun endDataSourceConnections() {
        playStoreBillingClient.endConnection()
        // normally you don't worry about closing a DB connection unless you have more than
        // one DB open. so no need to call 'localCacheBillingClient.close()'
        Log.d(LOG_TAG, "endDataSourceConnections")
    }

    /**
     * Correlated data sources belong inside a repository module so that the rest of
     * the app can have appropriate access to the data it needs. Still, it may be effective to
     * track the opening (and sometimes closing) of data source connections based on lifecycle
     * events. One convenient way of doing that is by calling this
     * [startSetup] when the [BillingViewModel] is instantiated and
     * [endDataSourceConnections] inside [ViewModel.onCleared]
     */
    fun startSetup(setupFinishedListener: OnIabSetupFinishedListener) {
        Log.d(LOG_TAG, "startDataSourceConnections")
        this.setupFinishedListener = setupFinishedListener
        connectToPlayBillingService()
    }

    private fun connectToPlayBillingService(): Boolean {
        Log.d(LOG_TAG, "connectToPlayBillingService")
        if (!playStoreBillingClient.isReady) {
            playStoreBillingClient.startConnection(this)
            return true
        }
        return false
    }

    // Checks that setup was done; if not, throws an exception.
    fun checkSetupDone(): Boolean {
        return playStoreBillingClient.isReady
    }


    fun querySubSkuDetailsAsync(subscriber: Subscriber<in MutableList<SkuDetails>>) {
        querySkuDetailsAsync(BillingClient.SkuType.SUBS, SUBS_SKUS, subscriber)
    }

    fun queryInAppSkuDetailsAsync(subscriber: Subscriber<in MutableList<SkuDetails>>) {
        querySkuDetailsAsync(BillingClient.SkuType.INAPP, INAPP_SKUS, subscriber)
    }

    /**
     * This is the callback for when connection to the Play [BillingClient] has been successfully
     * established. It might make sense to get [SkuDetails] and [Purchases][Purchase] at this point.
     */
    override fun onBillingSetupFinished(billingResult: BillingResult) {
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                Log.d(LOG_TAG, "onBillingSetupFinished successfully")

                setupFinishedListener.onIabSetupFinished(
                    IabResult(
                        BillingClient.BillingResponseCode.OK,
                        "Setup successful."
                    )
                )
                queryPurchasesAsync()
            }
            BillingClient.BillingResponseCode.BILLING_UNAVAILABLE -> {
                //Some apps may choose to make decisions based on this knowledge.
                Log.d(LOG_TAG, billingResult.debugMessage)
                setupFinishedListener.onIabSetupFinished(
                    IabResult(
                        BillingClient.BillingResponseCode.BILLING_UNAVAILABLE,
                        "Billing service unavailable on device."
                    )
                )
            }
            else -> {
                //do nothing. Someone else will connect it through retry policy.
                //May choose to send to server though
                Log.d(LOG_TAG, billingResult.debugMessage)
            }
        }
    }

    /**
     * This method is called when the app has inadvertently disconnected from the [BillingClient].
     * An attempt should be made to reconnect using a retry policy. Note the distinction between
     * [endConnection][BillingClient.endConnection] and disconnected:
     * - disconnected means it's okay to try reconnecting.
     * - endConnection means the [playStoreBillingClient] must be re-instantiated and then start
     *   a new connection because a [BillingClient] instance is invalid after endConnection has
     *   been called.
     **/
    override fun onBillingServiceDisconnected() {
        Log.d(LOG_TAG, "onBillingServiceDisconnected")
        connectToPlayBillingService()
    }

    /**
     * BACKGROUND
     *
     * Google Play Billing refers to receipts as [Purchases][Purchase]. So when a user buys
     * something, Play Billing returns a [Purchase] object that the app then uses to release the
     * [Entitlement] to the user. Receipts are pivotal within the [BillingRepository]; but they are
     * not part of the repo’s public API, because clients don’t need to know about them. When
     * the release of entitlements occurs depends on the type of purchase. For consumable products,
     * the release may be deferred until after consumption by Google Play; for non-consumable
     * products and subscriptions, the release may be deferred until after
     * [BillingClient.acknowledgePurchaseAsync] is called. You should keep receipts in the local
     * cache for augmented security and for making some transactions easier.
     *
     * THIS METHOD
     *
     * [This method][queryPurchasesAsync] grabs all the active purchases of this user and makes them
     * available to this app instance. Whereas this method plays a central role in the billing
     * system, it should be called at key junctures, such as when user the app starts.
     *
     * Because purchase data is vital to the rest of the app, this method is called each time
     * the [BillingViewModel] successfully establishes connection with the Play [BillingClient]:
     * the call comes through [onBillingSetupFinished]. Recall also from Figure 4 that this method
     * gets called from inside [onPurchasesUpdated] in the event that a purchase is "already
     * owned," which can happen if a user buys the item around the same time
     * on a different device.
     */
    fun queryPurchasesAsync() {
        Log.d(LOG_TAG, "queryPurchasesAsync called")
        val purchasesResult = HashSet<Purchase>()
        if (isSubscriptionSupported()) {
            playStoreBillingClient.queryPurchasesAsync(
                QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.SUBS).build()
            ) { result, purchasesList ->
                purchasesList.apply { purchasesResult.addAll(this) }
                Log.d(LOG_TAG, "queryPurchasesAsync SUBS results: ${purchasesList.size}")
                processPurchases(purchasesResult)
            }

        }

    }

    fun querySubPurchasesHistorySync(purchasesResponseListener: PurchaseHistoryResponseListener) {
        playStoreBillingClient.queryPurchaseHistoryAsync(
            QueryPurchaseHistoryParams.newBuilder().setProductType(BillingClient.ProductType.SUBS).build(),
            purchasesResponseListener
        )
    }

    fun querySubPurchasesSync(purchasesResponseListener: PurchasesResponseListener) {
        playStoreBillingClient.queryPurchasesAsync(
            QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.SUBS).build(),
            purchasesResponseListener
        )
    }

    fun queryInAppPurchasesSync(purchasesResponseListener: PurchasesResponseListener) {
        playStoreBillingClient.queryPurchasesAsync(
            QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build(),
            purchasesResponseListener
        )
    }

    private fun processPurchases(purchasesResult: Set<Purchase>) =
        CoroutineScope(Job() + Dispatchers.IO).launch {
            Log.d(LOG_TAG, "processPurchases called")
            val validPurchases = HashSet<Purchase>(purchasesResult.size)
            Log.d(LOG_TAG, "processPurchases newBatch content $purchasesResult")
            purchasesResult.forEach { purchase ->
                if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
                    if (isSignatureValid(purchase)) {
                        validPurchases.add(purchase)
                    } else {
                        Timber.e("Signature inValid")
                    }
                } else if (purchase.purchaseState == Purchase.PurchaseState.PENDING) {
                    Log.d(LOG_TAG, "Received a pending purchase of SKU: ${purchase.skus[0]}")
                    // handle pending purchases, e.g. confirm with users about the pending
                    // purchases, prompt them to complete it, etc.
                }
            }
            val (consumables, nonConsumables) = validPurchases.partition {
                SubSku.CONSUMABLE_SKUS.contains(it.skus[0])
            }
            Log.d(LOG_TAG, "processPurchases consumables content $consumables")
            Log.d(LOG_TAG, "processPurchases non-consumables content $nonConsumables")
            /*
              As is being done in this sample, for extra reliability you may store the
              receipts/purchases to a your own remote/local database for until after you
              disburse entitlements. That way if the Google Play Billing library fails at any
              given point, you can independently verify whether entitlements were accurately
              disbursed. In this sample, the receipts are then removed upon entitlement
              disbursement.
             */
            handleConsumablePurchasesAsync(consumables)
            acknowledgeNonConsumablePurchasesAsync(nonConsumables)
        }

    /**
     * Recall that Google Play Billing only supports two SKU types:
     * [in-app products][BillingClient.SkuType.INAPP] and
     * [subscriptions][BillingClient.SkuType.SUBS]. In-app products are actual items that a
     * user can buy, such as a house or food; subscriptions refer to services that a user must
     * pay for regularly, such as auto-insurance. Subscriptions are not consumable.
     *
     * Play Billing provides methods for consuming in-app products because they understand that
     * apps may sell items that users will keep forever (i.e. never consume) such as a house,
     * and consumable items that users will need to keep buying such as food. Nevertheless, Google
     * Play leaves the distinction for which in-app products are consumable entirely up to you.
     *
     * If an app wants its users to be able to keep buying an item, it must call
     * [BillingClient.consumeAsync] each time they buy it. This is because Google Play won't let
     * users buy items that they've previously bought but haven't consumed. In Trivial Drive, for
     * example, consumeAsync is called each time the user buys gas; otherwise they would never be
     * able to buy gas or drive again once the tank becomes empty.
     */
    private fun handleConsumablePurchasesAsync(consumables: List<Purchase>) {
        Log.d(LOG_TAG, "handleConsumablePurchasesAsync called")
        consumables.forEach {
            Log.d(LOG_TAG, "handleConsumablePurchasesAsync foreach it is $it")
            val params =
                ConsumeParams.newBuilder().setPurchaseToken(it.purchaseToken).build()
            playStoreBillingClient.consumeAsync(params) { billingResult, purchaseToken ->
                when (billingResult.responseCode) {
                    BillingClient.BillingResponseCode.OK -> {
                        Log.d(LOG_TAG, "handleConsumablePurchasesAsync success")
                        mPurchaseListener?.onIabPurchaseFinished(
                            IabResult(
                                BillingClient.BillingResponseCode.OK,
                                "Success"
                            ), null
                        )
                        // Update the appropriate tables/databases to grant user the items
                        purchaseToken.apply { }
                    }
                    else -> {
                        Log.w(LOG_TAG, billingResult.debugMessage)
                        mPurchaseListener?.onIabPurchaseFinished(
                            IabResult(
                                BillingClient.BillingResponseCode.ERROR,
                                "ERROR"
                            ), null
                        )
                        Log.d(
                            LOG_TAG, "handleConsumablePurchasesAsync response is ${
                                billingResult
                                    .debugMessage
                            }"
                        )
                    }
                }
            }
        }
    }

    /**
     * If you do not acknowledge a purchase, the Google Play Store will provide a refund to the
     * users within a few days of the transaction. Therefore you have to implement
     * [BillingClient.acknowledgePurchaseAsync] inside your app.
     */
    private fun acknowledgeNonConsumablePurchasesAsync(nonConsumables: List<Purchase>) {
        nonConsumables.forEach { purchase ->
            val params = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(
                purchase
                    .purchaseToken
            ).build()
            playStoreBillingClient.acknowledgePurchase(params) { billingResult ->
                when (billingResult.responseCode) {
                    BillingClient.BillingResponseCode.OK -> {
                        Log.d(LOG_TAG, "acknowledgeNonConsumablePurchasesAsync success")
                        mPurchaseListener?.onIabPurchaseFinished(
                            IabResult(
                                BillingClient.BillingResponseCode.OK,
                                "Success"
                            ), null
                        )
                    }
                    else -> {
                        mPurchaseListener?.onIabPurchaseFinished(
                            IabResult(
                                BillingClient.BillingResponseCode.ERROR,
                                "ERROR"
                            ), null
                        )
                        Log.d(
                            LOG_TAG, "acknowledgeNonConsumablePurchasesAsync response is ${
                                billingResult
                                    .debugMessage
                            }"
                        )
                    }
                }
            }

        }
    }


    /**
     * Ideally your implementation will comprise a secure server, rendering this check
     * unnecessary. @see [Security]
     */
    private fun isSignatureValid(purchase: Purchase): Boolean {
        return Security.verifyPurchase(
            Security.BASE_64_ENCODED_PUBLIC_KEY, purchase.originalJson, purchase.signature
        )
    }

    /**
     * Checks if the user's device supports subscriptions
     */
    private fun isSubscriptionSupported(): Boolean {
        val billingResult =
            playStoreBillingClient.isFeatureSupported(BillingClient.FeatureType.SUBSCRIPTIONS)
        var succeeded = false
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.SERVICE_DISCONNECTED -> connectToPlayBillingService()
            BillingClient.BillingResponseCode.OK -> succeeded = true
            else -> Log.w(
                LOG_TAG,
                "isSubscriptionSupported() error: ${billingResult.debugMessage}"
            )
        }
        return succeeded
    }

    /**
     * Presumably a set of SKUs has been defined on the Google Play Developer Console. This
     * method is for requesting a (improper) subset of those SKUs. Hence, the method accepts a list
     * of product IDs and returns the matching list of SkuDetails.
     *
     * The result is passed to [onSkuDetailsResponse]
     */
    private fun querySkuDetailsAsync(
        @BillingClient.SkuType skuType: String,
        skuList: List<String>, subscriber: Subscriber<in MutableList<SkuDetails>>
    ) {

        val params = SkuDetailsParams.newBuilder().setSkusList(skuList).setType(skuType).build()
        Log.d(LOG_TAG, "querySkuDetailsAsync for $skuType")
        playStoreBillingClient.querySkuDetailsAsync(params) { billingResult, skuDetailsList ->
            when (billingResult.responseCode) {
                BillingClient.BillingResponseCode.OK -> {
                    if (skuDetailsList.orEmpty().isNotEmpty()) {
                        skuDetailsList?.forEach {
                            MyBaseApp.getDb(mContext!!).googlePlaySkuDetails.update(it)
                        }
                    }
                    subscriber.onNext(skuDetailsList)
                }
                else -> {
                    Log.e(LOG_TAG, billingResult.debugMessage)
                }
            }
        }
    }

    var mPurchaseListener: OnIabPurchaseFinishedListener? = null

    /**
     * This is the function to call when user wishes to make a purchase. This function will
     * launch the Google Play Billing flow. The response to this call is returned in
     * [onPurchasesUpdated]
     */
    fun launchBillingFlow(
        activity: FragmentActivity,
        sku: String,
        purchaseFinishedListener: OnIabPurchaseFinishedListener?
    ) =
        launchBillingFlow(
            activity, SkuDetails(
                MyBaseApp.getDb(mContext!!).googlePlaySkuDetails.getSkuOriginalJson(sku)
                    ?: ""
            ), purchaseFinishedListener
        )

    fun launchBillingFlow(
        activity: FragmentActivity, skuDetails: SkuDetails, purchaseFinishedListener:
        OnIabPurchaseFinishedListener?
    ) {
        val purchaseParams = BillingFlowParams.newBuilder().setSkuDetails(skuDetails)
            .build()
        this.mPurchaseListener = purchaseFinishedListener
        playStoreBillingClient.launchBillingFlow(activity, purchaseParams)
    }


    /**
     * This method is called by the [playStoreBillingClient] when new purchases are detected.
     * The purchase list in this method is not the same as the one in
     * [queryPurchases][BillingClient.queryPurchases]. Whereas queryPurchases returns everything
     * this user owns, [onPurchasesUpdated] only returns the items that were just now purchased or
     * billed.
     *
     * The purchases provided here should be passed along to the secure server for
     * [verification](https://developer.android.com/google/play/billing/billing_library_overview#Verify)
     * and safekeeping. And if this purchase is consumable, it should be consumed, and the secure
     * server should be told of the consumption. All that is accomplished by calling
     * [queryPurchasesAsync].
     */
    override fun onPurchasesUpdated(
        billingResult: BillingResult,
        purchases: MutableList<Purchase>?
    ) {
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                Log.d(LOG_TAG, "purchase success")
                // will handle server verification, consumables, and updating the local cache
                purchases?.apply { processPurchases(this.toSet()) }
            }
            BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> {
                // item already owned? call queryPurchasesAsync to verify and process all such items
                Log.i(LOG_TAG, billingResult.debugMessage + billingResult.responseCode)
                mPurchaseListener?.onIabPurchaseFinished(
                    IabResult(
                        billingResult.responseCode,
                        "item already"
                    ), null
                )
                queryPurchasesAsync()
            }
            BillingClient.BillingResponseCode.SERVICE_DISCONNECTED -> {
                Log.i(LOG_TAG, billingResult.debugMessage + billingResult.responseCode)
                mPurchaseListener?.onIabPurchaseFinished(
                    IabResult(
                        billingResult.responseCode,
                        "disconnected"
                    ), null
                )
                connectToPlayBillingService()
            }
            else -> {
                Log.i(LOG_TAG, billingResult.debugMessage + billingResult.responseCode)
                mPurchaseListener?.onIabPurchaseFinished(
                    IabResult(
                        billingResult.responseCode, "Problem purchashing " +
                                "item."
                    ), null
                )
            }
        }
    }

    /**
     * Callback that notifies when a purchase is finished.
     */
    interface OnIabPurchaseFinishedListener {
        /**
         * Called to notify that an in-app purchase finished. If the purchase was successful,
         * then the sku parameter specifies which item was purchased. If the purchase failed,
         * the sku and extraData parameters may or may not be null, depending on how far the purchase
         * process went.
         *
         * @param result The result of the purchase.
         * @param info The purchase information (null if purchase failed)
         */
        fun onIabPurchaseFinished(result: IabResult, info: Purchase?)
    }

    /**
     * Callback for setup process. This setupFinishedListener's [.onIabSetupFinished] method is called
     * when the setup process is complete.
     */
    interface OnIabSetupFinishedListener {
        /**
         * Called to notify that setup is complete.
         *
         * @param result The result of the setup process.
         */
        fun onIabSetupFinished(result: IabResult)
    }


    companion object {
        private const val LOG_TAG = "BillingRepository"

        @Volatile
        private var INSTANCE: BillingRepository? = null

        @JvmStatic
        fun getInstance(ctx: Context): BillingRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: BillingRepository(ctx)
                        .also { INSTANCE = it }
            }
    }

    /**
     * [INAPP_SKUS], [SUBS_SKUS], [CONSUMABLE_SKUS]:
     *
     * If you don't need customization ,then you can define these lists and hardcode them here.
     * That said, there are use cases where you may need customization:
     *
     * - If you don't want to update your APK (or Bundle) each time you change your SKUs, then you
     *   may want to load these lists from your secure server.
     *
     * - If your design is such that users can buy different items from different Activities or
     * Fragments, then you may want to define a list for each of those subsets. I only have two
     * subsets: INAPP_SKUS and SUBS_SKUS
     */

    private object SubSku {

        const val GOLD_STATUS_SKUS = "golden" // coincidence that there only gold_status is a sub

        //一次性购买消耗性商品，即可以重复购买
        val CONSUMABLE_SKUS = listOf(GOLD_STATUS_SKUS)

        //一次性购买非消耗性商品，不可以重复购买
        val INAPP_SKUS = GoRouter.getInstance().getService(GooglePayService::class.java)!!.getRemoveAdsId()

        //订阅商品
        val SUBS_SKUS = listOf(
            GoRouter.getInstance().getService(GooglePayService::class.java)!!.getMonthId(), GoRouter.getInstance().getService(GooglePayService::class.java)!!.getQuarterlyId(),
            GoRouter.getInstance().getService(GooglePayService::class.java)!!.getYearlyId()
        )
    }
}


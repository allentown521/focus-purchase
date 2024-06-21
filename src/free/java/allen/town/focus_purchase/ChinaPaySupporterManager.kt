package allen.town.focus_purchase

import allen.town.core.service.AliPayService
import allen.town.core.service.GooglePayService
import allen.town.core.service.PayService
import allen.town.focus_common.util.EntityDateUtils
import allen.town.focus_common.util.Timber
import allen.town.focus_purchase.MyBaseApp.getDb
import allen.town.focus_purchase.alipay.AliPayEntry
import allen.town.focus_purchase.alipay.AliPayServiceWrap
import allen.town.focus_purchase.data.db.table.GooglePlayInAppTable
import allen.town.focus_purchase.iap.SupporterException
import allen.town.focus_purchase.iap.SupporterManager
import allen.town.focus_purchase.iap.util.GooglePayUtil
import allen.town.focus_purchase.ui.AliPayFragment
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.alipay.demo.trade.model.TradeStatus
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.SkuDetails
import com.wyjson.router.GoRouter
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers

class ChinaPaySupporterManager(val context: Context) : SupporterManager() {


    override fun restoreTip(): Int {
        return allen.town.focus_common.R.string.restore_tip
    }


    override fun getSupporterSubItem(): Observable<List<SkuDetails>> {
        return Observable.create<List<SkuDetails>> { subscriber: Subscriber<in List<SkuDetails>> ->
            val skuDetailList = ArrayList<SkuDetails>()
            skuDetailList.add(
                SkuDetails(
                    GooglePayUtil.toGoogleSkuDetail
                        (
                        GoRouter.getInstance().getService(GooglePayService::class.java)!!.getMonthId(),
                        BillingClient.SkuType.SUBS,
                        GoRouter.getInstance().getService(AliPayService::class.java)!!.getMonthPrice()
                    )
                )
            )
            skuDetailList.add(
                SkuDetails(
                    GooglePayUtil.toGoogleSkuDetail
                        (
                        GoRouter.getInstance().getService(GooglePayService::class.java)!!.getQuarterlyId(),
                        BillingClient.SkuType.SUBS,
                        GoRouter.getInstance().getService(AliPayService::class.java)!!.getQuarterlyPrice()
                    )
                )
            )
            skuDetailList.add(
                SkuDetails(
                    GooglePayUtil.toGoogleSkuDetail
                        (
                        GoRouter.getInstance().getService(GooglePayService::class.java)!!.getYearlyId(),
                        BillingClient.SkuType.SUBS,
                        GoRouter.getInstance().getService(AliPayService::class.java)!!.getYearlyPrice()
                    )
                )
            )
            subscriber.onNext(skuDetailList)
            subscriber.onCompleted()

        }
    }

    override fun getExpriedDate(): String? {
        val aliPayEntry = MyBaseApp.getDb(context!!).alipayPurchase().entry()
        return aliPayEntry?.run {
            try {
                return EntityDateUtils.timeStamp2Date(aliPayEntry.expiredTime?.toLong() ?: 0)
            } catch (ex: Exception) {
                Timber.e("addOneday", ex)
            }

            null
        }

    }

    override fun restore(ordId: String): Observable<Boolean> {
        return Observable.create { subscriber: Subscriber<in Boolean?> ->
            Timber.i("try to get purchase status from alipay server")
            val builder = AlipayTradeQueryRequestBuilder()
                .setTradeNo(ordId)

            val fQueryResult = AliPayServiceWrap.tradeWithHBService?.queryTradeResult(builder)
            if (fQueryResult?.tradeStatus == TradeStatus.SUCCESS) {
                //此订单打款时间
                val serverTime = fQueryResult.response?.sendPayDate
                val totalAmount = fQueryResult.response?.totalAmount
                var expiredTime = 0L
                if (GoRouter.getInstance().getService(AliPayService::class.java)!!.getQuarterlyPrice().toFloat() == totalAmount?.toFloat()) {
                    expiredTime = EntityDateUtils.addDays(serverTime, 90)
                } else if (GoRouter.getInstance().getService(AliPayService::class.java)!!.getYearlyPrice().toFloat() == totalAmount?.toFloat()) {
                    expiredTime = EntityDateUtils.addDays(serverTime, 365)
                } else if (GoRouter.getInstance().getService(AliPayService::class.java)!!.getMonthPrice().toFloat() == totalAmount?.toFloat()) {
                    expiredTime = EntityDateUtils.addDays(serverTime, 30)
                } else if (GoRouter.getInstance().getService(AliPayService::class.java)!!.getWeeklyPrice().toFloat() == totalAmount?.toFloat()) {
                    expiredTime = EntityDateUtils.addDays(serverTime, 7)
                } else {
                    Timber.e("not found  price sku ${totalAmount} ")
                }

                if (GoRouter.getInstance().getService(AliPayService::class.java)!!.getRemoveAdPrice().toFloat() == totalAmount?.toFloat()) {
                    Timber.i("is alipay remove ad")
                    GoRouter.getInstance().getService(PayService::class.java)!!.setRemoveAdPurchase(true)
                    getDb(context!!).googlePlayInAppPurchase
                        .update(GooglePlayInAppTable.TYPE_REMOVE_ADS, ordId)
                    subscriber.onNext(true)
                    subscriber.onCompleted()
                    return@create
                }

                if (expiredTime < System.currentTimeMillis()) {
                    Timber.i("alipay expried")
                    GoRouter.getInstance().getService(PayService::class.java)!!.setPurchase(false)
                    subscriber.onNext(false)
                    subscriber.onCompleted()
                } else {
                    Timber.i("alipay not expried")
                    GoRouter.getInstance().getService(PayService::class.java)!!.setPurchase(true)
                    MyBaseApp.getDb(context!!).alipayPurchase()
                        .update(expiredTime, ordId)
                    subscriber.onNext(true)
                    subscriber.onCompleted()
                }

            } else if (fQueryResult?.tradeStatus == TradeStatus.FAILED) {
                Timber.i("query alipay trade is no")
                GoRouter.getInstance().getService(PayService::class.java)!!.setPurchase(false)
                subscriber.onNext(false)
                subscriber.onCompleted()
            } else {
                //其他情况不处理
                Timber.i("query alipay trade is unknown")
                subscriber.onError(SupporterException("query alipay trade is unknown"))
            }


        }
    }

    override fun isSupporter(): Observable<Boolean> {
        return Observable.create { subscriber: Subscriber<in Boolean?> ->

            val purchased = MyBaseApp.getDb(context!!).alipayPurchase().isCharged()
            //查询付费状态并赋值
            Timber.i("alipay local is pro? $purchased")
            GoRouter.getInstance().getService(PayService::class.java)!!.setPurchase(purchased)
            subscriber.onNext(purchased)
            subscriber.onCompleted()


            if (purchased) {
                // 创建查询请求builder，设置请求参数
                val ordId = MyBaseApp.getDb(context!!).alipayPurchase().getOrdId()
                restore(ordId).subscribeOn(Schedulers.io()).subscribe({
                    if (!it) {
                        //如果最终发现是已过期那么删除数据库
                        Timber.i("found alipay expired so delete")
                        MyBaseApp.getDb(context!!).alipayPurchase().delete()
                    }
                }, {
                    Timber.e(it, "query alipay failed")
                })
            }


        }
    }

    /**
     * 检查购买了去广告商品
     */
    override fun isRemoveAdsSupporter(): Observable<Boolean?>? {
        return Observable.create { subscriber: Subscriber<in Boolean?> ->

            val isCharged = getDb(context!!).googlePlayInAppPurchase.isCharged(GooglePlayInAppTable.TYPE_REMOVE_ADS)
            GoRouter.getInstance().getService(PayService::class.java)!!.setRemoveAdPurchase(isCharged)

            //查询本地付费状态并赋值
            Timber.i("local is remove ads? $isCharged")


            if (isCharged) {
                // 创建查询请求builder，设置请求参数
                val ordId = MyBaseApp.getDb(context!!).getGooglePlayInAppPurchase().getOrdId()
                restore(ordId).subscribeOn(Schedulers.io()).subscribe({
                    if (!it) {
                        //如果最终发现是已过期那么删除数据库
                        Timber.i("found alipay expired so delete")
                        MyBaseApp.getDb(context!!).getGooglePlayInAppPurchase().delete(GooglePlayInAppTable.TYPE_REMOVE_ADS)
                    }
                }, {
                    Timber.e(it, "query alipay failed")
                })
            }


        }
    }


    override fun becomeSubSupporter(activity: FragmentActivity?, sku: String?): Observable<Boolean>? {
        return Observable.create { subscriber: Subscriber<in Boolean> ->
            var aliPayEntry: AliPayEntry? = null
            if (sku == GoRouter.getInstance().getService(GooglePayService::class.java)!!.getQuarterlyId()) {
                aliPayEntry = AliPayEntry(
                    sku,
                    String.format(
                        "%s  %s",
                        activity?.getString(allen.town.focus_common.R.string.subscribe_quaterly),
                        GoRouter.getInstance().getService(AliPayService::class.java)!!.getQuarterlyPrice()
                    ),
                    "",
                    GoRouter.getInstance().getService(AliPayService::class.java)!!.getQuarterlyPrice()
                )

            } else if (sku == GoRouter.getInstance().getService(GooglePayService::class.java)!!.getYearlyId()) {
                aliPayEntry = AliPayEntry(
                    sku,
                    String.format(
                        "%s  %s",
                        activity?.getString(allen.town.focus_common.R.string.subscribe_yearly),
                        GoRouter.getInstance().getService(AliPayService::class.java)!!.getYearlyPrice()
                    ),
                    "",
                    GoRouter.getInstance().getService(AliPayService::class.java)!!.getYearlyPrice()
                )
            } else if (sku == GoRouter.getInstance().getService(GooglePayService::class.java)!!.getMonthId()) {
                aliPayEntry = AliPayEntry(
                    GoRouter.getInstance().getService(GooglePayService::class.java)!!.getMonthId(),
                    String.format(
                        "%s  %s",
                        activity?.getString(allen.town.focus_common.R.string.subscribe_monthly),
                        GoRouter.getInstance().getService(AliPayService::class.java)!!.getMonthPrice()
                    ), "", GoRouter.getInstance().getService(AliPayService::class.java)!!.getMonthPrice()
                )
            }


            AliPayFragment(aliPayEntry!!, subscriber).showIt(activity!!.supportFragmentManager)
        }
    }

    override fun becomeInAppSubSupporter(activity: FragmentActivity?, skuDetails: SkuDetails?, type: String?): Observable<Boolean>? {
        return Observable.create { subscriber: Subscriber<in Boolean> ->
            var aliPayEntry: AliPayEntry? = null
            val sku = skuDetails?.sku
            if (sku == GoRouter.getInstance().getService(GooglePayService::class.java)!!.getRemoveAdsId()[0]) {
                aliPayEntry = AliPayEntry(
                    sku,
                    String.format(
                        "%s  %s",
                        "去广告",
                        GoRouter.getInstance().getService(AliPayService::class.java)!!.getRemoveAdPrice()
                    ),
                    "",
                    GoRouter.getInstance().getService(AliPayService::class.java)!!.getRemoveAdPrice()
                )

            }


            AliPayFragment(aliPayEntry!!, subscriber).showIt(activity!!.supportFragmentManager)
        }
    }

}
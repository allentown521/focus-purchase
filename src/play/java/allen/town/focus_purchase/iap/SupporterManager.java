package allen.town.focus_purchase.iap;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.SkuDetails;
import com.wyjson.router.GoRouter;

import java.util.List;

import allen.town.core.service.GooglePayService;
import allen.town.core.service.PayService;
import allen.town.focus.reader.data.db.table.GooglePlayInAppTable;
import allen.town.focus.reader.iap.BillingRepository;
import allen.town.focus_common.util.Timber;
import allen.town.focus_purchase.MyBaseApp;
import allen.town.focus_purchase.iap.util.IabException;
import allen.town.focus_purchase.iap.util.IabResult;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class SupporterManager {


    public final BillingRepository supporterHelper;

    protected SupporterManager(Context context) {
        this.supporterHelper = new BillingRepository(context.getApplicationContext());
    }


    /**
     * 恢复订单
     */
    public Observable<Boolean> restore(String ordId) {
        return null;
    }

    /**
     * 返回订单过期时间
     *
     * @return 格式化后的时间
     */
    public String getExpriedDate() {
        return null;
    }

    /**
     * 返回订单过期时间
     *
     * @return 格式化后的时间
     */
    public int restoreTip() {
        return 0;
    }

    /**
     * 检查购买了该商品
     */
    public Observable<Boolean> isSupporter() {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {

            public void call(Subscriber<? super Boolean> subscriber) {

                boolean isCharged = MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayPurchase().isCharged();
                GoRouter.getInstance().getService(PayService.class).setPurchase(isCharged);

                //查询本地付费状态并赋值
                Timber.i("local is pro? " + isCharged);

                if (SupporterManager.this.supporterHelper.checkSetupDone()) {
                    SupporterManager.this.checkSupporterSubPurchase(subscriber);

                } else {
                    SupporterManager.this.supporterHelper.startSetup(iabResult -> finishIabSetup(subscriber,
                            iabResult));
                }
            }

            public final void finishIabSetup(Subscriber subscriber, IabResult iabResult) {
                if (iabResult.isFailure()) {
                    subscriber.onError(new SupporterException(iabResult.getMessage()));
                } else {
                    SupporterManager.this.checkSupporterSubPurchase(subscriber);
                }
            }
        });
    }


    /**
     * 检查购买了去广告商品
     */
    public Observable<Boolean> isRemoveAdsSupporter() {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {

            public void call(Subscriber<? super Boolean> subscriber) {

                boolean isCharged = MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayInAppPurchase().isCharged(GooglePlayInAppTable.TYPE_REMOVE_ADS);
                GoRouter.getInstance().getService(PayService.class).setRemoveAdPurchase(isCharged);

                //查询本地付费状态并赋值
                Timber.i("local is remove ads? " + isCharged);

                if (SupporterManager.this.supporterHelper.checkSetupDone()) {
                    SupporterManager.this.checkSupporterInAppRemoveAds(subscriber);

                } else {
                    SupporterManager.this.supporterHelper.startSetup(iabResult -> finishIabSetup(subscriber,
                            iabResult));
                }
            }

            public final void finishIabSetup(Subscriber subscriber, IabResult iabResult) {
                if (iabResult.isFailure()) {
                    subscriber.onError(new SupporterException(iabResult.getMessage()));
                } else {
                    SupporterManager.this.checkSupporterInAppRemoveAds(subscriber);
                }
            }
        });
    }

    /**
     * 查询该产品对应的订阅商品信息
     *
     * @return
     */
    public Observable<List<SkuDetails>> getSupporterSubItem() {
        return Observable.create(subscriber -> {
            if (this.supporterHelper.checkSetupDone()) {
                getSupporterSubItem(subscriber);
            } else {
                this.supporterHelper.startSetup(iabResult -> {
                    if (iabResult.isFailure()) {
                        subscriber.onError(new SupporterException(iabResult.getMessage()));
                    } else {
                        getSupporterSubItem(subscriber);
                    }
                });
            }
        });
    }

    /**
     * 查询该产品对应的一次性商品信息
     *
     * @return
     */
    public Observable<List<SkuDetails>> getSupporterInAppItem() {
        return Observable.create(subscriber -> {
            if (this.supporterHelper.checkSetupDone()) {
                getSupporterInAppItem(subscriber);
            } else {
                this.supporterHelper.startSetup(iabResult -> {
                    if (iabResult.isFailure()) {
                        subscriber.onError(new SupporterException(iabResult.getMessage()));
                    } else {
                        getSupporterInAppItem(subscriber);
                    }
                });
            }
        });
    }


    /**
     * 发起订阅内购
     *
     * @param activity
     * @return
     */
    public Observable<Boolean> becomeSubSupporter(FragmentActivity activity, String sku) {
        return Observable.create(subscriber -> {
            if (this.supporterHelper.checkSetupDone()) {
                launchSubPurchaseFlow(activity, sku, subscriber);
            } else {
                this.supporterHelper.startSetup(iabResult -> {
                    if (iabResult.isFailure()) {
                        subscriber.onError(new SupporterException(iabResult.getMessage()));
                    } else {
                        launchSubPurchaseFlow(activity, sku, subscriber);
                    }
                });
            }
        });
    }

    /**
     * 发起商品购买
     *
     * @param activity
     * @return
     */
    public Observable<Boolean> becomeInAppSubSupporter(FragmentActivity activity, SkuDetails sku, String type) {
        return Observable.create(subscriber -> {
            if (this.supporterHelper.checkSetupDone()) {
                launchInAppPurchaseFlow(activity, sku, type, subscriber);
            } else {
                this.supporterHelper.startSetup(iabResult -> {
                    if (iabResult.isFailure()) {
                        subscriber.onError(new SupporterException(iabResult.getMessage()));
                    } else {
                        launchInAppPurchaseFlow(activity, sku, type, subscriber);
                    }
                });
            }
        });
    }


    /**
     * 发起订阅内购流程
     *
     * @param activity
     * @param subscriber
     */
    private void launchSubPurchaseFlow(FragmentActivity activity, String sku, Subscriber<? super Boolean> subscriber) {
        this.supporterHelper.launchBillingFlow(activity, sku,
                (iabResult, purchase) -> {
                    int response = iabResult.getResponse();
                    if (response != BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
                        switch (response) {
                            case BillingClient.BillingResponseCode.OK:
                                //支付成功修改状态
                                GoRouter.getInstance().getService(PayService.class).setPurchase(true);
                                MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayPurchase().update(true);
                                subscriber.onNext(true);
                                subscriber.onCompleted();
                                return;
                            case BillingClient.BillingResponseCode.USER_CANCELED:
                                break;
                            default:
                                subscriber.onError(new IabException(iabResult));
                                return;
                        }
                    }
                    subscriber.onNext(false);
                    subscriber.onCompleted();
                });
    }

    /**
     * 发起一次性商品内购流程
     *
     * @param activity
     * @param subscriber
     */
    private void launchInAppPurchaseFlow(FragmentActivity activity, SkuDetails sku, String type, Subscriber<? super Boolean> subscriber) {
        this.supporterHelper.launchBillingFlow(activity, sku,
                (iabResult, purchase) -> {
                    int response = iabResult.getResponse();
                    if (response != BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
                        switch (response) {
                            case BillingClient.BillingResponseCode.OK:
                                //支付成功修改状态
                                if (GooglePlayInAppTable.TYPE_REMOVE_ADS.equals(type)) {
                                    GoRouter.getInstance().getService(PayService.class).setRemoveAdPurchase(true);
                                }
                                MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayInAppPurchase().update(type, "");
                                subscriber.onNext(true);
                                subscriber.onCompleted();
                                return;
                            case BillingClient.BillingResponseCode.USER_CANCELED:
                                break;
                            default:
                                subscriber.onError(new IabException(iabResult));
                                return;
                        }
                    }
                    subscriber.onNext(false);
                    subscriber.onCompleted();
                });
    }


    private void getSupporterSubItem(Subscriber<? super List<SkuDetails>> subscriber) {
        this.supporterHelper.querySubSkuDetailsAsync(subscriber);
    }

    private void getSupporterInAppItem(Subscriber<? super List<SkuDetails>> subscriber) {
        this.supporterHelper.queryInAppSkuDetailsAsync(subscriber);
    }

    public void dispose() {
        Timber.d("dispose purchase");
        supporterHelper.endDataSourceConnections();
    }


    /**
     * 检查是否订阅了该订阅商品
     *
     * @param subscriber
     */
    public void checkSupporterSubPurchase(Subscriber<? super Boolean> subscriber) {
        if (this.supporterHelper != null) {
            final boolean[] purchased = {false};
            getAllPurchases((billingResult, supporterPurchaseList) -> {
                for (Purchase supporterPurchase : supporterPurchaseList
                ) {
                    if (GoRouter.getInstance().getService(GooglePayService.class).getQuarterlyId().equals(supporterPurchase.getSkus().get(0))
                            || GoRouter.getInstance().getService(GooglePayService.class).getYearlyId().equals(supporterPurchase.getSkus().get(0))
                            || GoRouter.getInstance().getService(GooglePayService.class).getMonthId().equals(supporterPurchase.getSkus().get(0))
                            || GoRouter.getInstance().getService(GooglePayService.class).getOldMonthId().equals(supporterPurchase.getSkus().get(0))
                            || GoRouter.getInstance().getService(GooglePayService.class).getOldYearlyId().equals(supporterPurchase.getSkus().get(0))
                            || GoRouter.getInstance().getService(GooglePayService.class).getOldQuarterlyId().equals(supporterPurchase.getSkus().get(0))
                    ) {
                        if (supporterPurchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
                            if (supporterPurchase.isAcknowledged()) {
                                purchased[0] = true;
                                break;
                            } else {
                                Timber.w("purchased but not acknowledged");
                            }

                        }

                    }

                }

                //查询付费状态并赋值
                Timber.i("is pro? " + purchased[0]);
                GoRouter.getInstance().getService(PayService.class).setPurchase(purchased[0]);
                if (purchased[0]) {
                    MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayPurchase().update(true);
                } else {
                    MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayPurchase().delete();
                }
                subscriber.onNext(purchased[0]);
                subscriber.onCompleted();
            });

        } else {
            subscriber.onError(new SupporterException("In app billing helper not initialized"));
        }
    }

    /**
     * 恢复购买
     * 网上说querySubPurchasesSync从GooglePlay的缓存中获取，在getAllPurchasesHistory的回调中调用它会刷新缓存，我也不知道有没有用
     * 有个别用户反馈换手机后querySubPurchasesSync查询到是空，用户反馈日志此方式无效
     */
    public void restorePurchase() {

        getAllPurchasesHistory((billingResult, supporterPurchaseList) -> {
            for (PurchaseHistoryRecord supporterPurchase : supporterPurchaseList
            ) {
                Timber.d(supporterPurchase.toString());
            }
            isSupporter().subscribeOn(Schedulers.io()).observeOn(Schedulers.io())
                    .subscribe();
        });


    }

    /**
     * 检查是否购买了去广告商品
     *
     * @param subscriber
     */
    public void checkSupporterInAppRemoveAds(Subscriber<? super Boolean> subscriber) {
        if (this.supporterHelper != null) {
            final boolean[] purchased = {false};
            getAllInAppPurchases((billingResult, supporterPurchaseList) -> {

                for (Purchase supporterPurchase : supporterPurchaseList
                ) {
                    if (GoRouter.getInstance().getService(GooglePayService.class).getRemoveAdsId().contains(supporterPurchase.getSkus().get(0))) {
                        if (supporterPurchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
                            if (supporterPurchase.isAcknowledged()) {
                                purchased[0] = true;
                                break;
                            } else {
                                Timber.w("purchased but not acknowledged");
                            }

                        }

                    }

                }
                //查询付费状态并赋值
                Timber.i("is remove ads? " + purchased[0]);
                GoRouter.getInstance().getService(PayService.class).setRemoveAdPurchase(purchased[0]);
                if (purchased[0]) {
                    MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayInAppPurchase().update(GooglePlayInAppTable.TYPE_REMOVE_ADS, "");
                } else {
                    MyBaseApp.getDb(supporterHelper.getMContext()).getGooglePlayInAppPurchase().delete(GooglePlayInAppTable.TYPE_REMOVE_ADS);
                }
                subscriber.onNext(purchased[0]);
                subscriber.onCompleted();
            });

        } else {
            subscriber.onError(new SupporterException("In app billing helper not initialized"));
        }
    }

    /**
     * 查询所有的订阅商品付费情况
     *
     * @return
     * @throws IabException
     */
    private void getAllPurchases(PurchasesResponseListener purchasesResponseListener) {
        this.supporterHelper.querySubPurchasesSync(purchasesResponseListener);
    }

    /**
     * 查询所有的订阅商品付费情况
     *
     * @return
     * @throws IabException
     */
    private void getAllInAppPurchases(PurchasesResponseListener purchasesResponseListener) {
        this.supporterHelper.queryInAppPurchasesSync(purchasesResponseListener);
    }

    /**
     * 查询历史订阅
     *
     * @return
     * @throws IabException
     */
    private void getAllPurchasesHistory(PurchaseHistoryResponseListener purchasesResponseListener) {
        this.supporterHelper.querySubPurchasesHistorySync(purchasesResponseListener);
    }

}

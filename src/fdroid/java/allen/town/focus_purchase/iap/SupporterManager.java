package allen.town.focus_purchase.iap;


import androidx.fragment.app.FragmentActivity;

import com.android.billingclient.api.SkuDetails;

import java.util.List;

import allen.town.focus_common.util.Timber;
import rx.Observable;
import rx.Subscriber;

public class SupporterManager {



    protected SupporterManager() {
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

            }

        });
    }


    /**
     * 检查购买了去广告商品
     */
    public Observable<Boolean> isRemoveAdsSupporter() {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {

            public void call(Subscriber<? super Boolean> subscriber) {


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
        });
    }

    /**
     * 查询该产品对应的一次性商品信息
     *
     * @return
     */
    public Observable<List<SkuDetails>> getSupporterInAppItem() {
        return Observable.create(subscriber -> {
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
        });
    }



    public void dispose() {
        Timber.d("dispose purchase");
    }




}

package allen.town.focus_purchase

import allen.town.focus_common.util.Timber
import allen.town.focus_purchase.iap.SupporterManager
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.android.billingclient.api.SkuDetails
import rx.Observable
import rx.Subscriber

class ChinaPaySupporterManager(context: Context) : SupporterManager(context) {


    override fun restoreTip(): Int {
        return allen.town.focus_common.R.string.restore_tip
    }


    override fun getSupporterSubItem(): Observable<List<SkuDetails>> {
        return Observable.create<List<SkuDetails>> { subscriber: Subscriber<in List<SkuDetails>> ->
            val skuDetailList = ArrayList<SkuDetails>()
            subscriber.onNext(skuDetailList)
            subscriber.onCompleted()

        }
    }

    override fun getExpriedDate(): String? {
        return null

    }

    override fun restore(ordId: String): Observable<Boolean> {
        return Observable.create { subscriber: Subscriber<in Boolean?> ->
            Timber.i("try to get purchase status from alipay server")
                subscriber.onNext(false)
                subscriber.onCompleted()
        }
    }

    override fun isSupporter(): Observable<Boolean> {
        return Observable.create { subscriber: Subscriber<in Boolean?> ->
        }
    }

    override fun isRemoveAdsSupporter(): Observable<Boolean?>? {
        return Observable.create { subscriber: Subscriber<in Boolean?> ->

        }
    }


    override fun becomeSubSupporter(activity: FragmentActivity?, sku: String?): Observable<Boolean>? {
        return Observable.create { subscriber: Subscriber<in Boolean> ->
        }
    }

    override fun becomeInAppSubSupporter(activity: FragmentActivity?, skuDetails: SkuDetails?, type: String?): Observable<Boolean>? {
        return Observable.create { subscriber: Subscriber<in Boolean> ->
        }
    }

}
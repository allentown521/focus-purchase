package allen.town.focus_purchase.iap

import android.content.Context


/**
 * 工厂类,返回支付宝或者google play的支付实例
 */
object SupporterManagerWrap {
    /**
     * 用完以后记得dispose,不然状态会一直监听
     */
    @JvmStatic
    fun getSupporterManger(context: Context): SupporterManager {
        return SupporterManager()
    }
}
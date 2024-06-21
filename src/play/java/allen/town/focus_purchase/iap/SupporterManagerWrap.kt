package allen.town.focus_purchase.iap

import allen.town.core.service.PayService
import allen.town.focus_purchase.ChinaPaySupporterManager
import android.content.Context
import com.wyjson.router.GoRouter


/**
 * 工厂类,返回支付宝或者google play的支付实例
 */
object SupporterManagerWrap {
    /**
     * 用完以后记得dispose,不然状态会一直监听
     */
    @JvmStatic
    fun getSupporterManger(context: Context): SupporterManager {
        return SupporterManager(context)
    }
}
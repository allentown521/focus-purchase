package allen.town.focus_purchase.iap.util

import allen.town.focus_common.util.JsonHelper


object GooglePayUtil {
    @JvmStatic
    fun toGoogleSkuDetail(productId: String, type: String, price: String? = null): String {
        val skuDetail = GoogleSkuDetailWrap(productId, type, if (price.isNullOrEmpty())  null else "¥${price}")
        return JsonHelper.toJSONString(skuDetail)
    }

    const val ALIPAY_REMOVE_AD = "alipay_remove_ad"
}
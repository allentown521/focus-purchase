package allen.town.focus.reader.iap.util

import allen.town.focus_common.util.JsonHelper


object GooglePayUtil {
    @JvmStatic
    fun toGoogleSkuDetail(productId: String, type: String, price: String? = null): String {
        val skuDetail = GoogleSkuDetailWrap(productId, type, if (price.isNullOrEmpty())  null else "¥${price}")
        return JsonHelper.toJSONString(skuDetail)
    }
}
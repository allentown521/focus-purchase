package allen.town.focus_purchase.iap.util

import androidx.annotation.Keep

@Keep
data class GoogleSkuDetailWrap(val productId: String, val type: String, val price: String?) {

}
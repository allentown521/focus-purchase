package allen.town.focus_purchase.data.db

import allen.town.focus_purchase.data.db.table.GooglePlaySkuDetailsTable
import allen.town.focus_common.util.Timber
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.android.billingclient.api.SkuDetails
import com.squareup.sqlbrite.BriteDatabase

class GooglePlaySkuDetails(val briteDb: BriteDatabase) {
    fun update(skuDetails: SkuDetails) {
        val contentValues = ContentValues()
        contentValues.put(GooglePlaySkuDetailsTable.SKU, skuDetails.sku)
        contentValues.put(GooglePlaySkuDetailsTable.TYPE, skuDetails.type)
        contentValues.put(GooglePlaySkuDetailsTable.PRICE, skuDetails.price)
        contentValues.put(GooglePlaySkuDetailsTable.DESCRIPTION, skuDetails.description)
        contentValues.put(GooglePlaySkuDetailsTable.ORIGINAL_JSON, skuDetails.originalJson)
        Timber.d("google play sku detail success insert it")
        briteDb.insert(GooglePlaySkuDetailsTable.TABLE_NAME, contentValues, SQLiteDatabase.CONFLICT_REPLACE)
    }

    fun delete() {
        briteDb.delete(GooglePlaySkuDetailsTable.TABLE_NAME, null)
    }

    fun getSkuOriginalJson(sku: String): String? {
        val result = briteDb.query("select " + GooglePlaySkuDetailsTable.ORIGINAL_JSON + " from " +
                GooglePlaySkuDetailsTable
                        .TABLE_NAME + " where sku = ?", sku)
        result?.run {
            try {
                if (moveToNext()) {
                    return getString(getColumnIndex(GooglePlaySkuDetailsTable.ORIGINAL_JSON))
                }
            } catch (e: Exception) {
                Timber.e("getSkuOriginalJson failed", e)
            } finally {
                close()
            }
        }
        Timber.d("original json is null")
        return null
    }

}
package allen.town.focus_purchase.data.db

import allen.town.focus_purchase.alipay.AliPayEntry
import allen.town.focus.reader.data.db.table.AlipayPurchaseTable
import allen.town.focus_common.util.Timber
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.squareup.sqlbrite.BriteDatabase

class AlipayPurchase(val briteDb: BriteDatabase) {
    fun update(expiredTime: Long, ordId: String?) {
        val contentValues = ContentValues()
        contentValues.put(AlipayPurchaseTable.EXPIRED_TIME, expiredTime)
        contentValues.put(AlipayPurchaseTable.ORDER_ID, ordId)
        val result = briteDb.query("select * from " + AlipayPurchaseTable.TABLE_NAME)
        result?.run {
            try {
                if (moveToNext()) {
                    Timber.d("alipay purchased update it")
                    briteDb.update(AlipayPurchaseTable.TABLE_NAME, contentValues, null)
                    return
                }
            } finally {
                close()
            }
        }

        Timber.d("alipay purchase success insert it")
        briteDb.insert(AlipayPurchaseTable.TABLE_NAME, contentValues, SQLiteDatabase.CONFLICT_REPLACE)
    }

    fun delete() {
        briteDb.delete(AlipayPurchaseTable.TABLE_NAME, null)
    }

    fun entry(): AliPayEntry? {
        val result = briteDb.query("select * from " + AlipayPurchaseTable.TABLE_NAME)
        result?.run {
            try {
                if (moveToNext()) {
                    try {
                        val ordId = getString(getColumnIndex(AlipayPurchaseTable.ORDER_ID))
                        val subId = getString(getColumnIndex(AlipayPurchaseTable.SUB_ID))
                        val expiredTime = getString(getColumnIndex(AlipayPurchaseTable.EXPIRED_TIME))
                        return AliPayEntry(subId, ordId, null, null, expiredTime)
                    } catch (e: Exception) {
                        Timber.e("get alipay charged status failed", e)
                    }
                }
            } finally {
                close()
            }
        }
        return null
    }

    fun getOrdId(): String {
        val result = briteDb.query("select * from " + AlipayPurchaseTable.TABLE_NAME)
        result?.run {
            try {
                if (moveToNext()) {
                    try {
                        val ordId = getString(getColumnIndex(AlipayPurchaseTable.ORDER_ID))
                        Timber.v("ordId %s", ordId)
                        return ordId
                    } catch (e: Exception) {
                        Timber.e("get alipay charged status failed", e)
                    }
                }
            } finally {
                close()
            }
        }
        return ""
    }

    fun isCharged(): Boolean {
        val result = briteDb.query("select * from " + AlipayPurchaseTable.TABLE_NAME)
        result?.run {
            try {
                if (moveToNext()) {

                    val expiredTime = getString(getColumnIndex(AlipayPurchaseTable.EXPIRED_TIME))
                    Timber.d("expired_time %s", expiredTime)
                    return expiredTime.toLong() > System.currentTimeMillis()

                }
            } catch (e: Exception) {
                Timber.e("get alipay charged status failed", e)
            } finally {
                close()
            }
        }
        return false
    }

}
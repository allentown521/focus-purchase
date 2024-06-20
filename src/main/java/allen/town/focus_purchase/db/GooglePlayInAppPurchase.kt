package allen.town.focus.reader.data.db

import allen.town.focus.reader.data.db.table.AlipayPurchaseTable
import allen.town.focus.reader.data.db.table.GooglePlayInAppTable
import allen.town.focus_common.util.Timber
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.squareup.sqlbrite.BriteDatabase

class GooglePlayInAppPurchase(val briteDb: BriteDatabase) {
    fun update(type: String, id: String? = "") {
        val contentValues = ContentValues()
        contentValues.put(GooglePlayInAppTable.INAPP_TYPE, type)
        contentValues.put(GooglePlayInAppTable.INAPP_ID, id)
        val result =
            briteDb.query(
                "select * from " + GooglePlayInAppTable.TABLE_NAME + " where " + GooglePlayInAppTable.INAPP_TYPE + " = ?",
                type
            )
        result?.run {
            try {
                if (moveToNext()) {
                    Timber.d("google play in app purchased it $type")
                    return
                }
            } finally {
                close()
            }
        }

        Timber.d("google play in app purchase success insert it")
        briteDb.insert(
            GooglePlayInAppTable.TABLE_NAME,
            contentValues,
            SQLiteDatabase.CONFLICT_REPLACE
        )
    }

    fun delete(type: String) {
        briteDb.delete(
            GooglePlayInAppTable.TABLE_NAME,
            GooglePlayInAppTable.INAPP_TYPE + " = ?",
            type
        )
    }

    fun isCharged(type: String): Boolean {
        val result = briteDb.query(
            "select * from " + GooglePlayInAppTable.TABLE_NAME + " where " + GooglePlayInAppTable.INAPP_TYPE + " = ?",
            type
        )
        result?.run {
            try {
                if (moveToNext()) {
                    Timber.d("$type charged ")
                    return true

                }
            } catch (e: Exception) {
                Timber.e("get google play charged status failed", e)
            } finally {

                close()
            }
        }
        return false
    }

    fun getOrdId(): String {
        val result = briteDb.query("select * from " + GooglePlayInAppTable.TABLE_NAME)
        result?.run {
            try {
                if (moveToNext()) {
                    try {
                        val ordId = getString(getColumnIndex(GooglePlayInAppTable.INAPP_ID))
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

}
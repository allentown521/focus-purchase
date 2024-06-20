package allen.town.focus.reader.data.db

import allen.town.focus.reader.data.db.table.GooglePlayPurchaseTable
import allen.town.focus_common.util.Timber
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.squareup.sqlbrite.BriteDatabase

class GooglePlayPurchase(val briteDb: BriteDatabase) {
    fun update(isSub: Boolean) {
        val contentValues = ContentValues()
        contentValues.put(GooglePlayPurchaseTable.IS_SUB, isSub)
        val result = briteDb.query("select * from " + GooglePlayPurchaseTable.TABLE_NAME)
        result?.run {
            try {
                if (moveToNext()) {

                    Timber.d("google play purchased update it")
                    briteDb.update(GooglePlayPurchaseTable.TABLE_NAME, contentValues, null)
                    return
                }
            } finally {
                close()
            }
        }

        Timber.d("google play purchase success insert it")
        briteDb.insert(GooglePlayPurchaseTable.TABLE_NAME, contentValues, SQLiteDatabase.CONFLICT_REPLACE)
    }

    fun delete() {
        briteDb.delete(GooglePlayPurchaseTable.TABLE_NAME, null)
    }

    fun isCharged(): Boolean {
        val result = briteDb.query("select * from " + GooglePlayPurchaseTable.TABLE_NAME)
        result?.run {
            try {
                if (moveToNext()) {

                    val charged = getInt(getColumnIndex(GooglePlayPurchaseTable.IS_SUB)) == 1
                    Timber.d("charged ", charged)
                    return charged

                }
            } catch (e: Exception) {
                Timber.e("get google play charged status failed", e)
            } finally {

                close()
            }
        }
        return false
    }

}
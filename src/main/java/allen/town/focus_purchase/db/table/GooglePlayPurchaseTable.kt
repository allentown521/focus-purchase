package allen.town.focus.reader.data.db.table

import allen.town.focus_purchase.data.db.TableBuilder
import android.database.sqlite.SQLiteDatabase
import androidx.annotation.Keep

@Keep
object GooglePlayPurchaseTable {
    const val IS_SUB = "is_sub"
    const val TABLE_NAME = "google_play_purchase"

    @JvmStatic
    fun onUpdate(sQLiteDatabase: SQLiteDatabase?, i: Int, i2: Int) {
        if (i < 18) {
            sQLiteDatabase?.execSQL(
                TableBuilder(TABLE_NAME)
                    .addBooleanColumn(IS_SUB)
                    .build())
        }
    }

    @JvmStatic
    fun onCreate(sQLiteDatabase: SQLiteDatabase) {
        sQLiteDatabase.execSQL(TableBuilder(TABLE_NAME)
                .addBooleanColumn(IS_SUB)
                .build())
    }
}


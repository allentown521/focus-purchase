package allen.town.focus_purchase.data.db.table

import allen.town.focus_purchase.data.db.TableBuilder
import android.database.sqlite.SQLiteDatabase
import androidx.annotation.Keep

@Keep
object GooglePlayInAppTable {
    const val TYPE_REMOVE_ADS = "remove_ads"
    const val INAPP_TYPE = "inapp_type"
    const val INAPP_ID = "inapp_id"
    const val TABLE_NAME = "google_play_in_app"

    @JvmStatic
    fun onUpdate(sQLiteDatabase: SQLiteDatabase, i: Int, i2: Int) {
        if (i < 26) {
            sQLiteDatabase.execSQL(
                TableBuilder(TABLE_NAME)
                .addTextColumn(INAPP_TYPE)
                .build())
        }
        if (i < 27) {
            sQLiteDatabase.execSQL("ALTER TABLE google_play_in_app ADD COLUMN inapp_id TEXT")
        }
    }

    @JvmStatic
    fun onCreate(sQLiteDatabase: SQLiteDatabase) {
        sQLiteDatabase.execSQL(
            TableBuilder(TABLE_NAME)
            .addTextColumn(INAPP_TYPE)
            .addTextColumn(INAPP_ID)
                .build())
    }
}


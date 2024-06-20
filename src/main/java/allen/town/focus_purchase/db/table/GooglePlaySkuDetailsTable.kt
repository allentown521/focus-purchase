package allen.town.focus.reader.data.db.table

import allen.town.focus_purchase.data.db.TableBuilder
import android.database.sqlite.SQLiteDatabase
import androidx.annotation.Keep

@Keep
object GooglePlaySkuDetailsTable {
    const val TYPE = "type"
    const val SKU = "sku"
    const val PRICE = "price"
    const val TITLE = "title"
    const val DESCRIPTION = "description"
    const val ORIGINAL_JSON = "originalJson"
    const val TABLE_NAME = "google_play_sku_detail"

    @JvmStatic
    fun onUpdate(sQLiteDatabase: SQLiteDatabase, i: Int, i2: Int) {
        if (i < 20) {
            sQLiteDatabase.execSQL(
                TableBuilder(TABLE_NAME)
                    .addTextColumn(SKU, 4)
                    .addPrimaryKeyColumn(SKU)
                    .addTextColumn(PRICE)
                    .addTextColumn(TYPE, 4)
                    .addTextColumn(TITLE)
                    .addTextColumn(DESCRIPTION)
                    .addTextColumn(ORIGINAL_JSON)
                    .build())
        }
    }

    @JvmStatic
    fun onCreate(sQLiteDatabase: SQLiteDatabase) {
        sQLiteDatabase.execSQL(TableBuilder(TABLE_NAME)
                .addTextColumn(SKU, 4)
                .addPrimaryKeyColumn(SKU)
                .addTextColumn(PRICE)
                .addTextColumn(TYPE, 4)
                .addTextColumn(TITLE)
                .addTextColumn(DESCRIPTION)
                .addTextColumn(ORIGINAL_JSON)
                .build())
    }
}
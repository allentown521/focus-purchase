package allen.town.focus.reader.data.db.table

import allen.town.focus_purchase.data.db.TableBuilder
import android.database.sqlite.SQLiteDatabase
import androidx.annotation.Keep

@Keep
object AlipayPurchaseTable {
    const val EXPIRED_TIME = "expired_time"
    const val ORDER_ID = "order_id"
    const val SUB_ID = "sub_id"
    const val TABLE_NAME = "alipay_purchase"

    @JvmStatic
    fun onUpdate(sQLiteDatabase: SQLiteDatabase?, i: Int, i2: Int) {
        if (i < 10) {
            sQLiteDatabase?.execSQL(
                TableBuilder(TABLE_NAME)
                    .addTextColumn(EXPIRED_TIME)
                    .addTextColumn(ORDER_ID)
                    .addTextColumn(SUB_ID)
                    .addPrimaryKeyColumn(EXPIRED_TIME)
                    .build())
        }
    }

    @JvmStatic
    fun onCreate(sQLiteDatabase: SQLiteDatabase) {
        sQLiteDatabase?.execSQL(TableBuilder(TABLE_NAME)
                .addTextColumn(EXPIRED_TIME)
                .addTextColumn(ORDER_ID)
                .addTextColumn(SUB_ID)
                .addPrimaryKeyColumn(EXPIRED_TIME)
                .build())
    }
}


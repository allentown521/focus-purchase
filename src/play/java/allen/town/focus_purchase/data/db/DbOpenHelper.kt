package allen.town.focus_purchase.data.db

import allen.town.core.service.PayService
import allen.town.focus_purchase.data.db.table.AlipayPurchaseTable
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteDatabase
import allen.town.focus_purchase.data.db.table.GooglePlayInAppTable
import allen.town.focus_purchase.data.db.table.GooglePlayPurchaseTable
import allen.town.focus_purchase.data.db.table.GooglePlaySkuDetailsTable
import android.content.Context
import com.wyjson.router.GoRouter
import org.apache.commons.lang.ArrayUtils
import java.lang.RuntimeException
import java.lang.reflect.InvocationTargetException

class DbOpenHelper(context: Context?) : SQLiteOpenHelper(
    context,
    GoRouter.getInstance().getService(PayService::class.java)!!.purchaseDbName(),
    null as CursorFactory?,
    GoRouter.getInstance().getService(PayService::class.java)!!.dbVersion()
) {
    override fun onConfigure(sQLiteDatabase: SQLiteDatabase) {
        super.onConfigure(sQLiteDatabase)
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true)
        sQLiteDatabase.enableWriteAheadLogging()
    }

    override fun onCreate(sQLiteDatabase: SQLiteDatabase) {
        val clsArr = mergeTables
        val length = clsArr.size
        var i = 0
        while (i < length) {
            try {
                clsArr[i].getDeclaredMethod("onCreate", SQLiteDatabase::class.java)
                    .invoke(null, sQLiteDatabase)
                i++
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
                throw RuntimeException(e)
            } catch (e2: InvocationTargetException) {
                e2.printStackTrace()
                throw RuntimeException(e2)
            } catch (e3: NoSuchMethodException) {
                e3.printStackTrace()
                throw RuntimeException(e3)
            }
        }
    }

    override fun onUpgrade(sQLiteDatabase: SQLiteDatabase, i: Int, i2: Int) {
        val clsArr = mergeTables
        val length = clsArr.size
        var i3 = 0
        while (i3 < length) {
            val cls = clsArr[i3]
            try {
                cls.getDeclaredMethod(
                    "onUpdate",
                    SQLiteDatabase::class.java,
                    Integer.TYPE,
                    Integer.TYPE
                ).invoke(
                    null,
                    sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2)
                )
                i3++
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
                throw RuntimeException(e)
            } catch (e2: InvocationTargetException) {
                e2.printStackTrace()
                throw RuntimeException(e2)
            } catch (e3: NoSuchMethodException) {
                e3.printStackTrace()
                throw RuntimeException(e3)
            }
        }
    }

    val mergeTables: Array<Class<*>>
        get() {
            val sourceMergeTables = GoRouter.getInstance().getService(PayService::class.java)!!.mergeDbTables()
            return if (sourceMergeTables == null) {
                tables
            } else {
                ArrayUtils.addAll(
                    tables,
                    sourceMergeTables
                ) as Array<Class<*>>
            }
        }

    companion object {
        private val tables = arrayOf(
            AlipayPurchaseTable::class.java,
            GooglePlayPurchaseTable::class.java,
            GooglePlaySkuDetailsTable::class.java,
            GooglePlayInAppTable::class.java
        )
    }
}
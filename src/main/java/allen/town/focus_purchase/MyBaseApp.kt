package allen.town.focus_purchase

import allen.town.focus_purchase.data.db.BaseDb
import android.content.Context

object MyBaseApp {
    private var baseDb: BaseDb? = null

    @JvmStatic
    fun getDb(context: Context): BaseDb {
        if (baseDb == null) {
            baseDb = BaseDb(context)
        }
        return baseDb!!
    }
}
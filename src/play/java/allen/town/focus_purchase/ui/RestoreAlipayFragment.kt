package allen.town.focus_purchase.ui

import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentManager
import rx.Subscriber

class RestoreAlipayFragment(val subscriber: Subscriber<in Boolean?>) : AppCompatDialogFragment() {
    companion object {

    }


    lateinit var edit: EditText



    fun showIt(fragmentManager: FragmentManager) {
        show(fragmentManager, null as String?)
    }


}
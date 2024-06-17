package allen.town.focus_purchase.ui

import allen.town.focus_purchase.ChinaPaySupporterManager
import allen.town.focus_common.util.Timber
import allen.town.focus_common.views.AccentMaterialDialog
import allen.town.focus_common.views.AccentProgressDialog
import allen.town.focus_purchase.MyBaseApp
import allen.town.focus_purchase.R
import allen.town.focus_purchase.data.db.BaseDb
import allen.town.focus_purchase.iap.SupporterException
import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentManager
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RestoreAlipayFragment(val subscriber: Subscriber<in Boolean?>) : AppCompatDialogFragment() {
    companion object {

    }


    lateinit var edit: EditText


    lateinit var baseDb: BaseDb

    fun showIt(fragmentManager: FragmentManager) {
        show(fragmentManager, null as String?)
    }

    override fun onCreateDialog(bundle: Bundle?): Dialog {
        val inflate = LayoutInflater.from(activity)
            .inflate(R.layout.layout_restore_alipay, null as ViewGroup?)
        this.baseDb = MyBaseApp.getDb(requireActivity())

        edit = inflate.findViewById(R.id.ordId)

        val restoreButton: Button = inflate.findViewById(R.id.restore)
        restoreButton.setOnClickListener {
            if (!TextUtils.isEmpty(edit.editableText.toString().trim())) {

                val progressDialog = AccentProgressDialog.show(getContext(), "", getString(allen.town.focus_common.R.string.restore), true, false)
//                progressDialog.setMessage(getString(R.string.logging))

                ChinaPaySupporterManager(requireContext()).restore(
                    edit.editableText.toString().trim()
                ).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        subscriber.onNext(it)
                        subscriber.onCompleted()
                        progressDialog.dismiss()
                        dismiss()
                    }, {
                        Timber.d(it, "There was an error while query alipay order info")
                        progressDialog.dismiss()
                        dismiss()
                        subscriber.onError(SupporterException("There was an error while query alipay order info"))
                    })
            }
        }

        return AccentMaterialDialog(
            requireContext(),
            allen.town.focus_common.R.style.MaterialAlertDialogTheme
        ).setView(inflate).setTitle(allen.town.focus_common.R.string.restore_tip).create()
    }


}
package com.ccf.wc.baselib.ui

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.ccf.wc.baselib.R

@Route(path = Constants.ROUTE_ALERT_DIALOG)
class AlertDialogFragment : DialogFragment() {

    private val message by lazy { arguments?.getString(Constants.EXTRA_ALERT_MESSAGE) }
    private val defaultMessage = "Hello, I'm Richer."

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(activity!!)
            .create()
        val contentView =
            LayoutInflater.from(activity!!).inflate(R.layout.fragment_alert_dialog, null)
        dialog.setContentView(contentView)
        dialog.setMessage(message ?: defaultMessage)
        dialog.setButton(
            DialogInterface.BUTTON_POSITIVE,
            "Ok"
        ) { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()
        }
        return dialog
    }
}
package com.tutorials180.firstappfadp.AlertDialogPackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.tutorials180.firstappfadp.R

class AlertDialogScreen : AppCompatActivity() {

    var dialogTitle:String="Test"
    var dialogMessage:String="Test Message"

    lateinit var objectAlertDialogBuilder:AlertDialog.Builder

    lateinit var alertDialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog_screen)

        objectAlertDialogBuilder=AlertDialog.Builder(this)
        objectAlertDialogBuilder.setTitle(dialogTitle)

        objectAlertDialogBuilder.setMessage(dialogMessage)
        objectAlertDialogBuilder.setCancelable(false)

        objectAlertDialogBuilder.setPositiveButton("Close")
        {d,id->
            alertDialog.dismiss()
        }

        alertDialog=objectAlertDialogBuilder.create()
        alertDialog.show()
    }
}
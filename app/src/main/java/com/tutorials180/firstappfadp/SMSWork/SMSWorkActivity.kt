package com.tutorials180.firstappfadp.SMSWork

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.tutorials180.firstappfadp.R
import java.lang.Exception

class SMSWorkActivity : AppCompatActivity()
{
    private lateinit var smsTextET:EditText
    private lateinit var smsReceiverPhoneNumberET:EditText

    private lateinit var sendSMSBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smswork)

        smsTextET=findViewById(R.id.sms_page_sms_text_et)
        smsReceiverPhoneNumberET=findViewById(R.id.sms_page_sms_receiver_number_et)

        sendSMSBtn=findViewById(R.id.sms_page_send_btn)
        sendSMSBtn.setOnClickListener { checkForPermissions() }
    }

    private fun checkForPermissions()
    {
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
        {
            //We will request for permission
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS),100)
        }
        else
        {
            sendSMSToUser()
        }
    }

    private fun sendSMSToUser()
    {
       try
       {
           if(smsTextET.text.toString().isNotBlank() && smsReceiverPhoneNumberET.text.toString().isNotBlank())
           {
               val smsTextFromUser=smsTextET.text.toString()
               val smsReceiverPhoneNumber=smsReceiverPhoneNumberET.text.toString()

               val objSmsManager:SmsManager=SmsManager.getDefault()
               objSmsManager.sendTextMessage(smsReceiverPhoneNumber,null,smsTextFromUser,null,null)
           }
           else
           {
               Toast.makeText(applicationContext,"Some fields are left empty",Toast.LENGTH_LONG).show()
           }
       }
       catch (ex:Exception)
       {
           Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
       }
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==100)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(applicationContext,"Permission Not Granted",Toast.LENGTH_LONG).show()
            }
        }
    }







}
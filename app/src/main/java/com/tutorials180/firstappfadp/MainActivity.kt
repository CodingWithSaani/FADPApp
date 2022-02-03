package com.tutorials180.firstappfadp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.firstappfadp.AlertDialogPackage.AlertDialogScreen
import com.tutorials180.firstappfadp.CustomListAdapter.CustomListPage
import com.tutorials180.firstappfadp.DataAdapterWork.SimpleListPage
import com.tutorials180.firstappfadp.FirebaseWorking.FirebaseAuthActivity
import com.tutorials180.firstappfadp.FirebaseWorking.FirebaseWorkingActivity
import com.tutorials180.firstappfadp.LocationWorking.LocationWorkingActivity
import com.tutorials180.firstappfadp.RecyclerViewImplementation.RVActivity
import com.tutorials180.firstappfadp.RoomImplementation.SimpleRoomActivity
import com.tutorials180.firstappfadp.SMSWork.SMSWorkActivity

class MainActivity : AppCompatActivity() {

    lateinit var firstValueET:EditText
    lateinit var secondValueET:EditText

    lateinit var calculateBtn:Button
    lateinit var resultTV:TextView

    lateinit var moveBtn:Button
    lateinit var moveToListScreenBtn:Button

    lateinit var moveToAlertScreenBtn:Button
    lateinit var moveToCustomListPageBtn:Button

    lateinit var moveToRoomPage:Button
    lateinit var moveToSMSPage:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectXML()
    }

    private fun connectXML()
    {
        firstValueET=findViewById(R.id.fist_value_et)
        secondValueET=findViewById(R.id.second_value_et)

        resultTV=findViewById(R.id.result_tv)
        calculateBtn=findViewById(R.id.calculate_btn)

        moveBtn=findViewById(R.id.move_btn)
        moveToAlertScreenBtn=findViewById(R.id.move_alert_screen_btn)

        moveToListScreenBtn=findViewById(R.id.move_list_screen_btn)
        moveToCustomListPageBtn=findViewById(R.id.move_custom_list_screen_btn)

        moveToRoomPage=findViewById(R.id.move_room_screen_btn)
        moveToSMSPage=findViewById(R.id.move_sms_screen_btn)

        moveToSMSPage.setOnClickListener {
//            startActivity(Intent(MainActivity@this,SMSWorkActivity::class.java))
//            startActivity(Intent(MainActivity@this,RVActivity::class.java))

            //startActivity(Intent(MainActivity@this,FirebaseWorkingActivity::class.java))
            //startActivity(Intent(MainActivity@this,FirebaseAuthActivity::class.java))
            startActivity(Intent(MainActivity@this,LocationWorkingActivity::class.java))
        }
        moveToRoomPage.setOnClickListener {
            startActivity(Intent(MainActivity@this,SimpleRoomActivity::class.java))
        }
        calculateBtn.setOnClickListener {
            calculate()
        }

        moveBtn.setOnClickListener {
            //moveToSecondScreen()
            moveObjectFromMainToSecond()
        }

        moveToAlertScreenBtn.setOnClickListener {
            moveToAlertPage()
        }

        moveToListScreenBtn.setOnClickListener {
            moveToListPage()
        }

        moveToCustomListPageBtn.setOnClickListener {
            moveToCustomListPageMethod()
        }
    }

    private fun moveToCustomListPageMethod() {
        startActivity(Intent(this,CustomListPage::class.java))
    }

    private fun moveToListPage() {
        startActivity(Intent(this,SimpleListPage::class.java))
    }

    private fun moveToAlertPage() {
        startActivity(Intent(this,AlertDialogScreen::class.java))
    }

    private fun moveToSecondScreen() {
        //Ali
        //23
        var objectIntent=Intent(this,SecondScreen::class.java)
        objectIntent.putExtra("name","Ali")

        objectIntent.putExtra("rollNo",23)
        startActivity(objectIntent)
    }


    private fun calculate()
    {
       if(firstValueET.text.toString().isNotBlank()
           && secondValueET.text.toString().isNotBlank())
       {
           var valueOne=firstValueET.text.toString().toInt()
           var valueTwo=secondValueET.text.toString().toInt()

           var sum=valueOne+valueTwo
           resultTV.text=sum.toString()

           firstValueET.text.clear()
           secondValueET.text.clear()

           firstValueET.requestFocus()
       }
       else if(firstValueET.text.toString().isBlank())
       {
           Toast.makeText(this,getString(R.string.warning_one)
               ,Toast.LENGTH_LONG).show()
           firstValueET.requestFocus()
       }
        else if(secondValueET.text.toString().isBlank())
       {
           Toast.makeText(this,getString(R.string.warning_two)
               ,Toast.LENGTH_LONG).show()
           secondValueET.requestFocus()
       }
    }

    private fun moveObjectFromMainToSecond()
    {
        var ali=Student(1,"Ali","1998","ali@gmail.com")
        var hamza=Student(2,"Hamza","2000","h@gmail.com")

        var intentObject=Intent(this,SecondScreen::class.java)
        intentObject.putExtra("ali",ali)

        intentObject.putExtra("hamza",hamza)
        startActivity(intentObject)
    }










}
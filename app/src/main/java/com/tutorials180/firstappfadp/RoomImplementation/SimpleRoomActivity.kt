package com.tutorials180.firstappfadp.RoomImplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.tutorials180.firstappfadp.R
import com.tutorials180.firstappfadp.RoomImplementation.DataEntities.Student
import com.tutorials180.firstappfadp.RoomImplementation.Db.StudentDb
import java.lang.Exception

class SimpleRoomActivity : AppCompatActivity() {

    private lateinit var studentIdEt:EditText
    private lateinit var studentNameEt:EditText

    private lateinit var studentEmailEt:EditText
    private lateinit var saveStudentData:Button

    private lateinit var objStudentDb:StudentDb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_room)

        connectXMLViewsToKotlinViews()
    }

    private fun addValuesToDb()
    {
        try
        {
            //Step 1=> Getting all values that we need for student
            val studentId:Int=studentIdEt.text.toString().toInt()
            val studentName:String=studentNameEt.text.toString()

            val studentEmail:String=studentEmailEt.text.toString()
            //Step 2 => None of the values are blank

            if(studentId!=null && studentName.isNotBlank() && studentEmail.isNotBlank())
            {
                val currentStudent=Student(studentId,studentName,studentEmail)
                objStudentDb=Room.databaseBuilder(SimpleRoomActivity@this,StudentDb::class.java,"StudentDb")
                    .allowMainThreadQueries().build()

                val checkQuery=objStudentDb.getStudentDaoObject().addStudent(currentStudent)
                if(checkQuery!=0L)
                {
                    Toast.makeText(SimpleRoomActivity@this,"Student Added",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(SimpleRoomActivity@this,"Student Not Added",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(SimpleRoomActivity@this,"Some fields are left empty",Toast.LENGTH_LONG).show()
            }

        }
        catch (ex:Exception)
        {
            Toast.makeText(SimpleRoomActivity@this,ex.message.toString(),Toast.LENGTH_LONG).show()
        }
    }

    private fun connectXMLViewsToKotlinViews()
    {
        studentIdEt=findViewById(R.id.student_id_et)
        studentNameEt=findViewById(R.id.student_name_et)

        studentEmailEt=findViewById(R.id.student_email_et)
        saveStudentData=findViewById(R.id.save_Student_data_btn)

        saveStudentData.setOnClickListener { addValuesToDb() }
    }
}
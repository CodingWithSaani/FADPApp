package com.tutorials180.firstappfadp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondScreen : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

//        var someName=intent.getStringExtra("name")
//        var someRollNo=intent.getIntExtra("rollNo",0)

        var ali=intent.getSerializableExtra("ali") as Student
        var hamza=intent.getSerializableExtra("hamza") as Student

        Toast.makeText(this,"ID:"+ali.uId+"\n" +
                "Name:"+ali.uName+"\nDOB:"+ali.uDob+
        "\nEmail:"+ali.uEmail,Toast.LENGTH_LONG).show()

        Toast.makeText(this,"ID:"+hamza.uId+"\n" +
                "Name:"+hamza.uName+"\nDOB:"+hamza.uDob+
                "\nEmail:"+hamza.uEmail,Toast.LENGTH_LONG).show()

    }
}
package com.tutorials180.firstappfadp.RecyclerViewImplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials180.firstappfadp.R

class RVActivity : AppCompatActivity()
{
    val listOfCars = listOf(
                            Cars("Toyota",2000,"Manual"),
                            Cars("Honda",2022,"Auto"),
                            Cars("KIA",2020,"Manual-Auto")
                      )      //Declaration and Initialization


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvactivity)
    }
}
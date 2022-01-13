package com.tutorials180.firstappfadp.RecyclerViewImplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorials180.firstappfadp.R

class RVActivity : AppCompatActivity()
{
    val listOfCars = listOf(
                            Cars("Toyota",2000,"Manual"),
                            Cars("Honda",2022,"Auto"),
                            Cars("KIA",2020,"Manual-Auto"),
                            Cars("KIA",2020,"Manual-Auto"),
                            Cars("KIA",2020,"Manual-Auto"),
                            Cars("KIA",2020,"Manual-Auto"),
                            Cars("KIA",2020,"Manual-Auto"),
                            Cars("KIA",2020,"Manual-Auto"),
        Cars("KIA",2020,"Manual-Auto"),Cars("KIA",2020,"Manual-Auto"),Cars("KIA",2020,"Manual-Auto"),
        Cars("KIA",2020,"Manual-Auto")



                      )      //Declaration and Initialization

    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvactivity)

        recyclerView=findViewById(R.id.rv_recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)

        recyclerView.adapter=RVCustomAdapter(listOfCars)
    }
}
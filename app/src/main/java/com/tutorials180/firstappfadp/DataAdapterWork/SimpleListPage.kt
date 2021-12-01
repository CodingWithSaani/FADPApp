package com.tutorials180.firstappfadp.DataAdapterWork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.tutorials180.firstappfadp.R

class SimpleListPage : AppCompatActivity() {

    //Step - I define the data source
    var daysList=arrayOf("Monday","Monday","Monday","Monday","Monday","Monday",
        "Monday","Monday","Monday","Monday","Monday","Monday","Monday",
        "Monday","Monday","Monday","Monday","Monday","Monday",
        "Monday","Monday","Monday","Monday","Monday","Monday")

    //Step 2: Define the adapter view
    lateinit var daysListView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_page)

        daysListView=findViewById(R.id.days_list)
        var ourAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,daysList)

        daysListView.adapter=ourAdapter
    }
}
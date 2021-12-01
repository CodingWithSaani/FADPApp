package com.tutorials180.firstappfadp.CustomListAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.tutorials180.firstappfadp.R

class CustomListPage : AppCompatActivity() {

    var playerImages= arrayOf(R.drawable.mohammad_babar_azam,
        R.drawable.mohammad_babar_azam,R.drawable.mohammad_babar_azam
    ,R.drawable.mohammad_babar_azam,R.drawable.mohammad_babar_azam)

    var playerNames= arrayOf("Ali","Ali","Ali","Ali","Ali")
    lateinit var customListView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_page)

        customListView=findViewById(R.id.custom_list_view)
        var ourCustomizedAdapter=CustomArrayAdapter(this,playerNames,playerImages)

        customListView.adapter=ourCustomizedAdapter
    }









}
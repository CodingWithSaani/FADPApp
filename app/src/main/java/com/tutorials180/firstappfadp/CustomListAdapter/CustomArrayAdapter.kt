package com.tutorials180.firstappfadp.CustomListAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tutorials180.firstappfadp.R

class CustomArrayAdapter (context:Context,
var playerNames:Array<String>,var playerImages:Array<Int>)
    :ArrayAdapter<String>(context, R.layout.single_row,playerNames)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        var singleRow=LayoutInflater.from(context).inflate(R.layout.single_row,null,true)

        var playerIV=singleRow.findViewById(R.id.singleRow_iv) as ImageView
        var playerTV=singleRow.findViewById(R.id.singleRow_tv) as TextView

        playerIV.setImageResource(playerImages[position])
        playerTV.text=playerNames[position]

        return singleRow

    }
}
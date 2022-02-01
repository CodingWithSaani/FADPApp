package com.tutorials180.firstappfadp.LocationWorking

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.firstappfadp.R
import java.lang.Exception

class LocationWorkingActivity : AppCompatActivity()
{
    private lateinit var getCoordinatesBtn: Button
    private lateinit var latTV:TextView

    private lateinit var lanTV:TextView
    private lateinit var mLocationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_working)

        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        getCoordinatesBtn = findViewById(R.id.lw_get_coordinates_btn)
        latTV = findViewById(R.id.lw_lat_tv)

        lanTV = findViewById(R.id.lw_lan_tv)
        getCoordinatesBtn.setOnClickListener {
            getLocationDetails()
        }
    }

    private fun getLocationDetails() {
        try
        {
            if(ActivityCompat.checkSelfPermission(LocationWorkingActivity@this,
                Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
            {
                //Get location
            }
            else
            {
                ActivityCompat.requestPermissions(LocationWorkingActivity@this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),200)
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==200)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(applicationContext, "Permission Not Granted", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



















package com.tutorials180.firstappfadp.LocationWorking

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.firstappfadp.R
import java.lang.Exception
import java.util.*

class LocationWorkingActivity : AppCompatActivity(), LocationListener
{
    private lateinit var getCoordinatesBtn: Button
    private lateinit var latTV:TextView

    private lateinit var lanTV:TextView
    private lateinit var mLocationManager: LocationManager

    private lateinit var mGeoCoder : Geocoder
    private lateinit var locationTV:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_working)

        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        mGeoCoder = Geocoder(this,Locale.getDefault())

        locationTV = findViewById(R.id.lw_location_tv)
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
                mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                5000,
                    5f,
                    this
                )
            }
            else
            {
                ActivityCompat.requestPermissions(LocationWorkingActivity@this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),200)
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

    override fun onLocationChanged(p0: Location) {
        latTV.text = p0.latitude.toString()
        lanTV.text = p0.longitude.toString()

        reverseGeoCoding(p0)
    }


    private fun reverseGeoCoding(location:Location)
    {
        try {
            val physicalAddress =
                mGeoCoder.getFromLocation(location.latitude, location.longitude, 1)
            val streetAddress = physicalAddress[0].getAddressLine(0)

            val town = physicalAddress[0].subAdminArea
            val city = physicalAddress[0].locality

            val province = physicalAddress[0].adminArea
            val country = physicalAddress[0].countryName

            val postalCode = physicalAddress[0].postalCode
            Toast.makeText(
                applicationContext,
                "street Address:${streetAddress}," +
                        "town:${town},city:${city},province${province},country:${country}",
                Toast.LENGTH_SHORT
            ).show()

            locationTV.text = "street Address:${streetAddress}," +
                    "town:${town},city:${city},province${province},country:${country}"
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}



















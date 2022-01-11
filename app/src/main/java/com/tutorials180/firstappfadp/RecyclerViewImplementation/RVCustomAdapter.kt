package com.tutorials180.firstappfadp.RecyclerViewImplementation

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorials180.firstappfadp.R

class RVCustomAdapter(val listOfCars:List<Cars>):RecyclerView.Adapter<RVCustomAdapter.RvViewHolder>()
{
    class RvViewHolder(rvSingleRow: View):RecyclerView.ViewHolder(rvSingleRow)
    {
        var brandTV: TextView =rvSingleRow.findViewById(R.id.rv_sr_car_brand_tv)
        var modelTV:TextView = rvSingleRow.findViewById(R.id.rv_sr_car_model_tv)

        var typeTV:TextView=rvSingleRow.findViewById(R.id.rv_sr_car_type_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
package com.tutorials180.firstappfadp.RecyclerViewImplementation

import android.view.LayoutInflater
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

        val singleRow=LayoutInflater.from(parent.context).inflate(R.layout.rv_single_row,parent,false)
        val rvViewHolder=RvViewHolder(singleRow)

        return rvViewHolder
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.brandTV.text=listOfCars[position].brand
        holder.modelTV.text=listOfCars[position].model.toString()

        holder.typeTV.text=listOfCars[position].type
    }

    override fun getItemCount(): Int {
        return listOfCars.size
    }
}
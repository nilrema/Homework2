package com.example.homework2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2.databinding.OneCarLayoutBinding

class GarageRecyclerAdapter(private val context: Context, val carsList: ArrayList<Car>) :
    RecyclerView.Adapter<GarageRecyclerAdapter.GarageViewHolder>() {

    class GarageViewHolder(val binding: OneCarLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GarageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OneCarLayoutBinding.inflate(inflater, parent, false)
        return GarageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GarageViewHolder, position: Int) {
        val car = carsList[position]
        holder.binding.carInfo.text = car.toString()
    }

    override fun getItemCount(): Int {
        return carsList.size
    }
}


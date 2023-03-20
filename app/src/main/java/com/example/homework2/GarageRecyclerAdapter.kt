package com.example.homework2

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2.databinding.OneCarLayoutBinding
import com.squareup.picasso.Picasso

class GarageRecyclerAdapter(private val context: Context, val carsList: ArrayList<Car>) :
    RecyclerView.Adapter<GarageRecyclerAdapter.GarageViewHolder>() {

    inner class GarageViewHolder(val binding: OneCarLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val car = carsList[adapterPosition]
                val intent = Intent(itemView.context, CollapsibleToolbarActivity::class.java)
                intent.putExtra("car", car)
                itemView.context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GarageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OneCarLayoutBinding.inflate(inflater, parent, false)
        return GarageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GarageViewHolder, position: Int) {
        val car = carsList[position]
        val carInfo = "${car.make} ${car.model} (${car.color})"
        holder.binding.carInfo.text = carInfo


        when(car.make) {
            context.getString(R.string.Ferrari) -> holder.binding.itemImage.setImageResource(R.drawable.ferrarilogo)
            context.getString(R.string.Mercedes)  -> holder.binding.itemImage.setImageResource(R.drawable.mercedeslogo)
            context.getString(R.string.Mercedes_Benz) -> holder.binding.itemImage.setImageResource(R.drawable.mercedeslogo)
            context.getString(R.string.Toyota) -> holder.binding.itemImage.setImageResource(R.drawable.toyotalogo)
            context.getString(R.string.Honda) -> holder.binding.itemImage.setImageResource(R.drawable.hondalogo)
            context.getString(R.string.Ford) -> holder.binding.itemImage.setImageResource(R.drawable.fordlogo)
            context.getString(R.string.BMW) -> holder.binding.itemImage.setImageResource(R.drawable.bmwlogo)
            context.getString(R.string.Aston_Martin) -> holder.binding.itemImage.setImageResource(R.drawable.astonmartinlogo)
            context.getString(R.string.Rimac) -> holder.binding.itemImage.setImageResource(R.drawable.rimaclogo)
            context.getString(R.string.Mazda) -> holder.binding.itemImage.setImageResource(R.drawable.mazdalogo)
            context.getString(R.string.Volkswagen) -> holder.binding.itemImage.setImageResource(R.drawable.vwlogo)
            else -> holder.binding.itemImage.setImageResource(R.drawable.garage_house2)
        }

       /*holder.binding.root.backgroundTintList = ColorStateList.valueOf(
           when {
               car.price < 5000 -> context.getColor(R.color.light_green)
               car.price < 20000 -> context.getColor(R.color.light_yellow)
               else -> context.getColor(R.color.light_red)
           }
       )*/
    }

    override fun getItemCount(): Int {
        return carsList.size
    }
}


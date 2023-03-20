package com.example.homework2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.*
import com.example.homework2.databinding.OneCarLayoutBinding

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


        loadCarImage(car, holder.binding.itemImage, holder.itemView.context)

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
    private fun loadCarImage(car: Car, imageView: ImageView, context: Context) {
        val imageUrl = when(car.make) {
            context.getString(R.string.Ferrari) -> context.getString(R.string.ferrari_URL)
            context.getString(R.string.Mercedes), context.getString(R.string.Mercedes_Benz) -> context.getString(R.string.mercedes_URL)
            context.getString(R.string.Toyota) -> context.getString(R.string.toyota_URL)
            context.getString(R.string.Honda) -> context.getString(R.string.honda_URL)
            context.getString(R.string.Ford) -> context.getString(R.string.ford_URL)
            context.getString(R.string.BMW) -> context.getString(R.string.bmw_URL)
            context.getString(R.string.Aston_Martin) -> context.getString(R.string.astonmartin_URL)
            context.getString(R.string.Rimac) -> context.getString(R.string.rimac_URL)
            context.getString(R.string.Mazda) -> context.getString(R.string.mazda_URL)
            context.getString(R.string.Volkswagen) -> context.getString(R.string.volkswagen_URL)
            else -> null
        }

        if (imageUrl != null) {
            imageView.load(imageUrl) {
                placeholder(R.drawable.garage_house2)
            }
        } else {
            imageView.setImageResource(R.drawable.garage_house2)
        }
    }

}


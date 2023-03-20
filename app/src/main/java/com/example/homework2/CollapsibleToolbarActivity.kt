package com.example.homework2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.size.Scale
import com.example.homework2.databinding.ActivityCollapsibleToolbarBinding
import java.io.Serializable

class CollapsibleToolbarActivity : AppCompatActivity() {
    private lateinit var viewModel: GarageView
    private lateinit var binding : ActivityCollapsibleToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollapsibleToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GarageView::class.java]

        binding.scrollableImage.load("https://seeklogo.com/images/M/mechanic-garage-logo-DEAC6DDDCC-seeklogo.com.png") {
            crossfade(true)
            placeholder(R.drawable.garage_svgrepo_com)
            error(R.drawable.garage_svgrepo_com)
            scale(Scale.FILL)
        }


        val car = intent.serializable("car") as? Car
        if (car != null) {

                binding.scrollabletextview.text = buildString {
                    append("Make: ")
                    append(car.make)
                    append("\nModel: ")
                    append(car.model)
                    append("\nYear: ")
                    append(car.year)
                    append("\nColor: ")
                    append(car.color)
                    append("\nPrice: ")
                    append(car.price)
                    append("\nTyres: ")
                    append(car.tyres)
                }

                val carDescriptionMap = mapOf(
                    getString(R.string.Ferrari) to getString(R.string.ferrari_description),
                    getString(R.string.Mercedes) to getString(R.string.mercedes_description),
                    getString(R.string.Toyota) to getString(R.string.toyota_description),
                    getString(R.string.Honda) to getString(R.string.honda_description),
                    getString(R.string.Ford) to getString(R.string.ford_description),
                    getString(R.string.BMW) to getString(R.string.bmw_description),
                    getString(R.string.Aston_Martin) to getString(R.string.astonmartin_description),
                    getString(R.string.Rimac) to getString(R.string.rimac_description),
                    getString(R.string.Mazda) to getString(R.string.mazda_description),
                    getString(R.string.Volkswagen) to getString(R.string.volkswagen_description),
                    getString(R.string.VW) to getString(R.string.volkswagen_description),
                    getString(R.string.Mercedes_Benz) to getString(R.string.mercedes_description)
                )

                val tyresMap = mapOf(
                    Tyres.WINTER to getString(R.string.winter_description),
                    Tyres.SUMMER to getString(R.string.summer_description),
                    Tyres.SLICKS to getString(R.string.slicks_description),
                    Tyres.SEASON to getString(R.string.season_description)
                )



                val description = carDescriptionMap[car.make]
                if(description != null) {
                    binding.scrollableManufacturer.text = description
                }

                val tyreDescription = tyresMap[car.tyres]
                if(tyreDescription != null) {
                    binding.scrollableTyres.text = tyreDescription
                }

                when {
                    car.price < 10000 -> binding.scrollablePrice.text = getString(R.string.affordable_description)
                    car.price >= 10000 && car.price < 30000 -> binding.scrollablePrice.text = getString(R.string.midrange_description)
                    car.price >= 30000 -> binding.scrollablePrice.text = getString(R.string.expensive_description)
                }

            }
        }

    override fun onResume() {
        super.onResume()
        title = getString(R.string.details)
    }

    private inline fun <reified T : Serializable> Intent.serializable(key: String): T? = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getSerializableExtra(key) as? T
    }
}


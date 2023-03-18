package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.homework2.databinding.ActivityCollapsibleToolbarBinding

class CollapsibleToolbarActivity : AppCompatActivity() {
    private lateinit var viewModel: GarageView
    private lateinit var binding : ActivityCollapsibleToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollapsibleToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GarageView::class.java]

        val carPosition = intent.getIntExtra("car", -1)
        if (carPosition != -1) {
            val car = viewModel.garageLiveData.value?.get(carPosition)
            if (car != null) {
                if(car.make.equals(getString(R.string.Mercedes_Benz))) {
                    binding.scrollabletextview.text = getString(R.string.Mercedes_Benz)
                }

            }
        }
    }
}



package com.example.homework2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.homework2.databinding.FragmentP1Binding
import com.google.android.material.snackbar.Snackbar


class Fragment1 : Fragment() {

    private lateinit var viewModel : GarageView
    private lateinit var binding : FragmentP1Binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentP1Binding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity())[GarageView::class.java]

        val tyresAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.tyres_array,
            android.R.layout.simple_spinner_item
        )
        tyresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.tyresSpinner.adapter = tyresAdapter

        binding.addCarButton.setOnClickListener {
            val car = createCarFromInput()
            if (car != null) {
                viewModel.addVehicle(car)
                clear()

                val carInfo = "${car.make} ${car.model} (${car.color}), ${car.year}, ${car.price}"
                Snackbar.make(binding.root, "Added car: $carInfo", Snackbar.LENGTH_LONG).show()
                //Toast.makeText(requireContext(), getString(R.string.add_another_car), Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = getString(R.string.add)
    }


    private fun createCarFromInput(): Car? {
        val make = binding.makeEditText.getStringValue()
        val model = binding.modelEditText.getStringValue()
        val yearText = binding.yearEditText.getStringValue()
        val priceText = binding.priceEditText.getStringValue()

        if (make.isBlank() || model.isBlank()) {
            binding.makeEditText.error = getString(R.string.fill_fields)
            binding.makeEditText.requestFocus()
            return null
        }

        val year = yearText.toIntOrNull()
        if (year == null) {
            val errorText = getString(R.string.valid_year)
            binding.yearEditText.error = errorText
            binding.yearEditText.requestFocus()
            return null
        } else if(year < 1886 || year > 2024) {
            Toast.makeText(context, R.string.invalid_year, Toast.LENGTH_SHORT).show()
            return null
        }

        val price = priceText.toDoubleOrNull()
        if (price == null || price < 0) {
            binding.priceEditText.error = getString(R.string.valid_price)
            binding.priceEditText.requestFocus()
            return null
        }

        val colorRadioButton = binding.colorRadioGroup.findViewById<RadioButton>(binding.colorRadioGroup.checkedRadioButtonId)
        val color = when (colorRadioButton?.id) {
            R.id.red_radio_button -> Color.RED
            R.id.blue_radio_button -> Color.BLUE
            R.id.green_radio_button -> Color.GREEN
            R.id.yellow_radio_button -> Color.YELLOW
            R.id.purple_radio_button -> Color.PURPLE
            else -> Color.GREEN
        }

        val tyres = when (binding.tyresSpinner.selectedItem.toString()) {
            getString(R.string.winter_tyres) -> Tyres.WINTER
            getString(R.string.summer_tyres) -> Tyres.SUMMER
            getString(R.string.season_tyres) -> Tyres.SEASON
            getString(R.string.slicks) -> Tyres.SLICKS
            else -> Tyres.SEASON
        }


        return Car(make, model, year, color, price, tyres)
    }

    private fun clear() {
        val editTexts = listOf(binding.makeEditText, binding.modelEditText, binding.yearEditText, binding.priceEditText)
        for (editText in editTexts) {
            editText.clearText()
        }
    }

    private fun EditText.clearText() {
        text?.clear()
    }
    private fun EditText.getStringValue(): String {
        return this.text.toString()
    }
}
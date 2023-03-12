package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import com.example.homework2.databinding.FragmentP2Binding


class Fragment2 : Fragment() {

    private lateinit var viewModel: GarageView
    private lateinit var carsList: ListView
    private lateinit var binding: FragmentP2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentP2Binding.inflate(inflater, container, false)
        carsList = binding.garage

        viewModel = ViewModelProvider(requireActivity())[GarageView::class.java]
        viewModel.garageLiveData.observe(viewLifecycleOwner) { cars ->
            updateCarsList(cars)
        }
        return binding.root
    }

    private fun updateCarsList(garage: List<Car>) {
        val carListItems = ArrayList<String>()
        for (car in garage) {
            val item = "${car.make} ${car.model}, ${car.color}, ${car.price}, ${car.year}"
            carListItems.add(item)
        }

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, carListItems)
        carsList.adapter = adapter
    }

}



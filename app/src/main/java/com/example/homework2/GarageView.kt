package com.example.homework2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GarageView : ViewModel() {

    private val _garage = MutableLiveData<MutableList<Car>>(mutableListOf())

    val defaultCars = listOf(
        Car("Toyota", "Corolla", 2015, Color.BLUE, 15000.0, Tyres.SUMMER),
        Car("Honda", "Civic", 2018, Color.RED, 20000.0, Tyres.SEASON),
        Car("Ford", "Mustang", 2020, Color.YELLOW, 35000.0, Tyres.SLICKS),
        Car("BMW", "M3", 2019, Color.GREEN, 45000.0, Tyres.SUMMER),
        Car("Mercedes-Benz", "C-Class", 2017, Color.PURPLE, 28000.0, Tyres.WINTER),
        Car("Mercedes-Benz", "G-Wagen", 2019, Color.YELLOW, 100000.0, Tyres.WINTER),
        Car("Aston Martin", "Valkyrie", 2023, Color.GREEN, 2000000.0, Tyres.SLICKS),
        Car("Rimac", "Nevera", 2022, Color.BLUE, 2300000.0, Tyres.SLICKS),
        Car("Ferrari", "SF90 Stradale", 2021, Color.RED, 500000.0, Tyres.SUMMER),
        Car("Mazda", "6 SkyActive", 2016, Color.RED, 20000.0, Tyres.SEASON),
        Car("Volkswagen", "Golf 8 TDI", 2019, Color.PURPLE, 28000.0, Tyres.WINTER)

    ).toMutableList()
    init {
        _garage.value = defaultCars
    }

    val garageLiveData: LiveData<MutableList<Car>>
        get() = _garage

    fun addVehicle(car: Car) {
        _garage.value?.add(car)
        _garage.postValue(_garage.value)
    }
}

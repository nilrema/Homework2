package com.example.homework2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GarageView : ViewModel() {

    private val _garage = MutableLiveData<MutableList<Car>>(mutableListOf())

    val garageLiveData: LiveData<MutableList<Car>>
        get() = _garage

    fun addVehicle(car: Car) {
        _garage.value?.add(car)
        _garage.postValue(_garage.value)
    }
}

package com.example.weatherforecast.ui.addedCity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.model.City

class AddedCityViewModel: ViewModel() {

    val dataCity = MutableLiveData<ArrayList<City>>()

    fun getData() {
        dataCity.value = AddedCity.listAddedCity
    }

}
package com.example.weatherforecast.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.model.City
import com.example.weatherforecast.model.Weather
import com.example.weatherforecast.reposytory.WeatherRepository
import com.example.weatherforecast.ui.addedCity.AddedCity

class WeatherViewModel(private var repository: WeatherRepository): ViewModel() {

    val listData = MutableLiveData<ArrayList<Weather>>()

    val dataCity = MutableLiveData<ArrayList<String>>()

    fun getData() {
        dataCity.value = arrayListOf()

        val f = dataCity.value

        for(item in AddedCity.listAddedCity)
        {
            f?.add(item.nameCity)
        }

        dataCity.value = f
    }

    fun getListWeather(city: String) {
        listData.value = repository.searchByName(city)
    }

    fun getListWeatherDays(city: String) {
        listData.value = repository.searchByNameForDays(city)
    }
}
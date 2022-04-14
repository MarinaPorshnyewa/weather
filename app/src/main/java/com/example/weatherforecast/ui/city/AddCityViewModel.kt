package com.example.weatherforecast.ui.city

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.model.City
import com.example.weatherforecast.reposytory.CitiesRepository
import com.example.weatherforecast.ui.addedCity.AddedCity

class AddCityViewModel(private val repository: CitiesRepository) : ViewModel(){

    val listData = MutableLiveData<ArrayList<City>>()

    fun getData() {
        listData.value = repository.getListOfCities().map {
            City(it.nameCity)
        } as ArrayList<City>
    }

    fun removeItem(item: City){

        val newList = listData.value
        newList?.remove(item)
        listData.value = newList

        AddedCity.listAddedCity.add(item)
        
    }

}
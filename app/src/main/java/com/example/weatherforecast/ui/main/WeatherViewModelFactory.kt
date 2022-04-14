package com.example.weatherforecast.ui.main

import com.example.weatherforecast.reposytory.WeatherRepository
import com.zamana.myapplication.ui.base.BaseViewModelFactory

class WeatherViewModelFactory: BaseViewModelFactory<WeatherViewModel> (WeatherViewModel::class.java){
    override fun createViewModel(): WeatherViewModel {
        return WeatherViewModel(WeatherRepository())
    }

}
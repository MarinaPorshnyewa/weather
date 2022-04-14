package com.example.weatherforecast.reposytory

import com.example.weatherforecast.database.WeatherDataBase
import com.example.weatherforecast.database.WeatherEntity
import com.example.weatherforecast.model.Weather

class WeatherRepository {

    fun getListOfWeather() = ArrayList<WeatherEntity>(WeatherDataBase.listWeather)

    fun searchByName(city: String): ArrayList<Weather> {
        return WeatherDataBase.listWeather
            .find { it.nameCity == city }
            ?.listWeather ?: arrayListOf()
    }

    fun searchByNameForDays(city: String): ArrayList<Weather> {
        return WeatherDataBase.listWeatherDays
            .find { it.nameCity == city }
            ?.listWeather ?: arrayListOf()
    }

}
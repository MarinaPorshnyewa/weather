package com.example.weatherforecast.database

import com.example.weatherforecast.model.Weather

data class WeatherEntity (
    val nameCity: String,
    val listWeather: ArrayList<Weather>
)

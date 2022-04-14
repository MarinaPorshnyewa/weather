package com.example.weatherforecast.database

import com.example.weatherforecast.R
import com.example.weatherforecast.model.Weather
import kotlin.random.Random

object WeatherDataBase {

    val listPicture = arrayListOf(R.drawable.ic_sun, R.drawable.ic_cloud, R.drawable.ic_raining_clouds)
    val listDays = arrayListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val listTime = arrayListOf("01:00", "02:00", "03:00","04:00","05:00","06:00","07:00","08:00",
        "09:00","10:00","11:00","12:00","13:00", "14:00","15:00","16:00","17:00","18:00","19:00",
        "20:00","21:00","22:00","23:00","24:00")
    val listTemp = arrayListOf("+23", "+18", "+26", "+17")


    var weatherTime = arrayListOf<Weather>()

    fun randomWeatherTime(): ArrayList<Weather>{

        weatherTime = arrayListOf<Weather>()

        for (i in 0..23){
            weatherTime.add(Weather(listPicture.random(), listTime[i], listTemp.random()))
        }
        return weatherTime
    }


    var weatherDays = arrayListOf<Weather>()

    fun randomWeatherDays(): ArrayList<Weather>{

        weatherDays = arrayListOf<Weather>()

        for (i in 0..6){
            weatherDays.add(Weather(listPicture.random(), listDays[i], listTemp.random()))
        }
        return weatherDays
    }


    val listWeather = arrayListOf(
        WeatherEntity("Brest", randomWeatherTime()),
        WeatherEntity("Vitebsk", randomWeatherTime()),
        WeatherEntity("Gomel", randomWeatherTime()),
        WeatherEntity("Grodno", randomWeatherTime()),
        WeatherEntity("Minsk", randomWeatherTime()),
        WeatherEntity("Mogilev", randomWeatherTime())

    )

    val listWeatherDays = arrayListOf(
        WeatherEntity("Brest", randomWeatherDays()),
        WeatherEntity("Vitebsk", randomWeatherDays()),
        WeatherEntity("Gomel", randomWeatherDays()),
        WeatherEntity("Grodno", randomWeatherDays()),
        WeatherEntity("Minsk", randomWeatherDays()),
        WeatherEntity("Mogilev", randomWeatherDays())
    )


}
package com.example.weatherforecast.ui.main.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemWeatherBinding
import com.example.weatherforecast.model.Weather

class WeatherViewHolder(private val binding: ItemWeatherBinding, private val context: Context
) : RecyclerView.ViewHolder(binding.root){

    fun bind(weather: Weather){

        binding.imageWeather.setImageDrawable(context.getDrawable(weather.imageViewSrc))
        binding.textWeatherTimeOrDay.text = weather.timeOrDays
        binding.textWeatherTemp.text = weather.name
    }
}
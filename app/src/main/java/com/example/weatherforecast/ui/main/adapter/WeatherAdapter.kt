package com.example.weatherforecast.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemCityBinding
import com.example.weatherforecast.databinding.ItemWeatherBinding
import com.example.weatherforecast.model.City
import com.example.weatherforecast.model.Weather
import com.example.weatherforecast.ui.city.AddCityActivity
import com.example.weatherforecast.ui.city.adapter.CityViewHolder
import com.example.weatherforecast.ui.view.DialogAddCity

class WeatherAdapter (
    val context: Context,
) : RecyclerView.Adapter<WeatherViewHolder>(){

    private var list = arrayListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(context))
        return WeatherViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setDataList(data: ArrayList<Weather>){
        list = data
        notifyDataSetChanged()
    }

}
package com.example.weatherforecast.ui.addedCity.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemCityBinding
import com.example.weatherforecast.model.City

class AddedCityViewHolder(private val binding: ItemCityBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(city: City){
        binding.cityTitle.text = city.nameCity
    }
}
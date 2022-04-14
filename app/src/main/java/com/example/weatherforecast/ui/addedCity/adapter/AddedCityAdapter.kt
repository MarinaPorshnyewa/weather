package com.example.weatherforecast.ui.addedCity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemCityBinding
import com.example.weatherforecast.model.City

class AddedCityAdapter(
    val context: Context,
): RecyclerView.Adapter<AddedCityViewHolder>() {

    private var list = arrayListOf<City>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddedCityViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(context))
        return AddedCityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddedCityViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount() = list.size

    fun setDataList(data: ArrayList<City>){

        list = data
        notifyDataSetChanged()
    }
}
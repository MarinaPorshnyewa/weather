package com.example.weatherforecast.ui.city.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.ItemCityBinding
import com.example.weatherforecast.model.City
import com.example.weatherforecast.model.Weather
import com.example.weatherforecast.reposytory.CitiesRepository
import com.example.weatherforecast.ui.city.AddCityActivity
import com.example.weatherforecast.ui.city.AddCityFragment
import com.example.weatherforecast.ui.city.AddCityViewModel
import com.example.weatherforecast.ui.city.AddCityViewModelFactory
import com.example.weatherforecast.ui.main.MainFragment
import com.example.weatherforecast.ui.view.DialogAddCity

class CityAdapter (
    val context: Context,
    val onItemClick: (item: City) -> Unit
) : RecyclerView.Adapter<CityViewHolder>(){

    private var list = arrayListOf<City>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(context))
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {

            onItemClick(list[position])
        }

    }

    override fun getItemCount() = list.size

    fun setDataList(data: ArrayList<City>){
        list = data
        notifyDataSetChanged()
    }

}
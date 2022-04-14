package com.example.weatherforecast.reposytory

import android.content.Context
import androidx.core.content.edit
import com.example.weatherforecast.database.CitiesDataBase
import com.example.weatherforecast.database.CityEntity
import com.example.weatherforecast.model.City

private val CITY_DEFAULT_LIST = ArrayList<CityEntity>(CitiesDataBase.listCities)
private const val FILE_NAME = "shared_pref_file"
private const val CITY_LIST = "list_city"

class CitiesRepository(private val context: Context) {

    private val preferenses = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    fun setCityList(cityList: Set<String>) {
        preferenses.edit {
            putStringSet(CITY_LIST, cityList)
        }
    }

    fun getCity(): Set<String>? {

        val list = CITY_DEFAULT_LIST.map { it.nameCity } as Set<String>


        return preferenses.getStringSet(CITY_LIST, list)
    }

    fun getListOfCities() = ArrayList<CityEntity>(CitiesDataBase.listCities)
}
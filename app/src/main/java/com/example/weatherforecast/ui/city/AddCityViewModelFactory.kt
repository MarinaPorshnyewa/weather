package com.example.weatherforecast.ui.city

import android.content.Context
import com.example.weatherforecast.reposytory.CitiesRepository
import com.zamana.myapplication.ui.base.BaseViewModelFactory

class AddCityViewModelFactory : BaseViewModelFactory<AddCityViewModel>(AddCityViewModel::class.java){
    override fun createViewModel(): AddCityViewModel {
        return AddCityViewModel(CitiesRepository())
    }
}
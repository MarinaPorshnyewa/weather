package com.example.weatherforecast.ui.addedCity

import com.zamana.myapplication.ui.base.BaseViewModelFactory

class AddedCityViewModelFactory: BaseViewModelFactory<AddedCityViewModel>(AddedCityViewModel::class.java) {
    override fun createViewModel(): AddedCityViewModel {
        return AddedCityViewModel()
    }
}
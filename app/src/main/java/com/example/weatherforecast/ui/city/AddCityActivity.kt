package com.example.weatherforecast.ui.city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherforecast.R

class AddCityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_for_city_fragment, AddCityFragment())
            .commit()
    }
}
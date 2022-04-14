package com.example.weatherforecast.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.ActivityMainBinding
import com.example.weatherforecast.ui.addedCity.AddedCityFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()


        binding.bottomNavigation.setOnItemSelectedListener {

        when(it.itemId){
            R.id.city -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, AddedCityFragment())
                    .commit()
            }

            R.id.weather -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, MainFragment())
                    .commit()
            }

            R.id.settings -> {

            }
        }
            return@setOnItemSelectedListener true
        }

    }
}
package com.example.weatherforecast.ui.addedCity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherforecast.databinding.FragmentAddedCityBinding
import com.example.weatherforecast.ui.addedCity.adapter.AddedCityAdapter
import com.example.weatherforecast.ui.city.AddCityViewModel
import com.example.weatherforecast.ui.city.AddCityViewModelFactory
import com.example.weatherforecast.ui.city.adapter.CityAdapter

class AddedCityFragment :Fragment(){

    private lateinit var binding: FragmentAddedCityBinding

    lateinit var viewModel: AddedCityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddedCityBinding.inflate(inflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel = ViewModelProvider(this, AddedCityViewModelFactory()).get(AddedCityViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getData()

        viewModel.dataCity.observe(requireActivity()){

            binding.addedCity.run {
                adapter = AddedCityAdapter(requireContext())
                layoutManager = LinearLayoutManager(requireContext())

            }
            (binding.addedCity.adapter as AddedCityAdapter).setDataList(it)

        }

    }

}
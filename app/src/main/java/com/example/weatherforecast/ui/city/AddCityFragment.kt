package com.example.weatherforecast.ui.city

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherforecast.R
import com.example.weatherforecast.database.CitiesDataBase
import com.example.weatherforecast.database.CityEntity
import com.example.weatherforecast.databinding.ActivityAddCityBinding.bind
import com.example.weatherforecast.databinding.FragmentAddCityBinding
import com.example.weatherforecast.databinding.ItemCityBinding
import com.example.weatherforecast.model.City
import com.example.weatherforecast.reposytory.CitiesRepository
import com.example.weatherforecast.ui.city.adapter.CityAdapter
import com.example.weatherforecast.ui.city.adapter.CityViewHolder
import com.example.weatherforecast.ui.view.DialogAddCity

class AddCityFragment : Fragment() {

    private lateinit var binding: FragmentAddCityBinding

    lateinit var viewModel: AddCityViewModel
    lateinit var sharePreferences: CitiesRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCityBinding.inflate(inflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel = ViewModelProvider(this, AddCityViewModelFactory()).get(AddCityViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharePreferences = CitiesRepository(requireContext())

        viewModel.getData()

        viewModel.listData.observe(requireActivity()){

                binding.cityList.adapter = CityAdapter(requireContext()){

                    viewModel.removeItem(it)
                    DialogAddCity().show(parentFragmentManager,"")
                }
                binding.cityList.layoutManager = LinearLayoutManager(requireContext())

            (binding.cityList.adapter as CityAdapter).setDataList(it)


        }
    }

}

package com.example.weatherforecast.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.FragmentMainBinding
import com.example.weatherforecast.ui.city.AddCityFragment
import com.example.weatherforecast.ui.main.adapter.WeatherAdapter
import java.text.SimpleDateFormat
import java.util.*

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel =
            ViewModelProvider(this, WeatherViewModelFactory()).get(WeatherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addCityButton.setOnClickListener {

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, AddCityFragment())
                .commit()

        }

        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val formatedDate = formatter.format(date)

        binding.text.text = formatedDate

        viewModel.listData.observe(requireActivity()) {

            binding.weatherRecyclerView.run {
                adapter = WeatherAdapter(requireContext())
                layoutManager = LinearLayoutManager(requireContext())
            }
            (binding.weatherRecyclerView.adapter as WeatherAdapter).setDataList(it)


        }

        viewModel.getData()
        viewModel.dataCity.observe(requireActivity()) {

            val adapter: ArrayAdapter<*> =
                ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, it)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter


        }

        binding.info1.onClickInfo = {

            if (binding.spinner.isNotEmpty()) {
                viewModel.getListWeather(binding.spinner.selectedItem.toString())
            }
        }

        binding.info2.onClickInfo = {
            if (binding.spinner.isNotEmpty()) {
                viewModel.getListWeatherDays(binding.spinner.selectedItem.toString())
            }
        }
    }
}
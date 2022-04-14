package com.example.weatherforecast.ui.view

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.DialogAddCityBinding

class DialogAddCity: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = DialogAddCityBinding.inflate(layoutInflater)

        return AlertDialog.Builder(requireContext())
            .setView(view.root)
            .setTitle(R.string.dialog_title)
            .setPositiveButton(R.string.dialog_ok_button){
                dialog, _ ->
                view.dialogAddCity.text
            }
            .create()
    }
}
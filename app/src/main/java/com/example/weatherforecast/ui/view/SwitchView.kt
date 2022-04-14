package com.example.weatherforecast.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.ViewSwitchBinding

class SwitchView(context: Context?, attrs: AttributeSet?): LinearLayout(context, attrs) {

    var binding: ViewSwitchBinding

    var onClickInfo: (() -> Unit)? = null

    init {
        binding = ViewSwitchBinding.inflate(
            LayoutInflater.from(context), this
        )
        attrs?.let { setAttributes(it) }
        binding.title.setOnClickListener {
            onClickInfo?.invoke()
        }
    }

    private fun setAttributes(attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.SwitchView, 0, 0)
        try {
            binding.title.text = ta.getString(R.styleable.SwitchView_title)

        } finally {
            ta.recycle()
        }
    }
}
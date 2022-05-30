package com.linh.androiddeveloperchallenge.ratesvolume.presentation.binding

import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun View.setViewVisibility(isVisible: Boolean) {
    this.isVisible = isVisible
}

@BindingAdapter("isActive")
fun Button.setIsActive(isActive: Boolean) {
    if (isActive) {
        setBackgroundColor(ContextCompat.getColor(context, com.linh.androiddeveloperchallenge.common.R.color.red_300))
        setTextColor(ContextCompat.getColor(context, android.R.color.white))
    } else {
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        setTextColor(ContextCompat.getColor(context, android.R.color.black))
    }
}

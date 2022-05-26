package com.linh.androiddeveloperchallenge.ratesvolume.presentation.binding

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun View.setViewVisibility(isVisible: Boolean) {
    this.isVisible = isVisible
}

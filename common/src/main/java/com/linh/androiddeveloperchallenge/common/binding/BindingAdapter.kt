package com.linh.androiddeveloperchallenge.common.binding

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("backgroundRes")
fun View.setBackgroundRes(backgroundRes: Int) {
    this.setBackgroundResource(backgroundRes)
}

@BindingAdapter("textColorRes")
fun TextView.setTextColorRes(textColorRes: Int) {
    val color = ContextCompat.getColor(context, textColorRes)
    this.setTextColor(color)
}
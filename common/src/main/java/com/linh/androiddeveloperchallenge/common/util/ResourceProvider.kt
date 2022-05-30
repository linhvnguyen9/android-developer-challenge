package com.linh.androiddeveloperchallenge.common.util

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {
    val context: Context

    fun getString(@StringRes res: Int, vararg args: Any = emptyArray()): String
}

package com.linh.androiddeveloperchallenge.common.util.extensions

import kotlin.math.roundToInt

fun Double?.toFormattedString() = if (this == this?.roundToInt()?.toDouble()) this?.toInt().toString() else this?.toString()

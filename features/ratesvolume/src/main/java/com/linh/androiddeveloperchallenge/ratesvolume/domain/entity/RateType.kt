package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

sealed class RateType {
    object Wages
    data class PieceRate(val hourlyRate: Double)
}

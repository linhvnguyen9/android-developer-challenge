package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

sealed class RateType {
    object Wages: RateType()
    data class PieceRate(val hourlyRate: Double): RateType()
}

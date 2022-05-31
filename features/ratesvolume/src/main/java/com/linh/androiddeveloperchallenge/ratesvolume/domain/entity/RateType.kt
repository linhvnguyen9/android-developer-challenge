package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

enum class RateType {
    WAGES,
    PIECE_RATE;

    companion object {
        fun from(type: String) = values().find { type.uppercase() == it.name } ?: WAGES
    }
}

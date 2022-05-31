package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

enum class JobType {
    PRUNING,
    THINING;

    companion object {
        fun from(type: String) = values().find { it.name == type.uppercase() } ?: PRUNING
    }
}

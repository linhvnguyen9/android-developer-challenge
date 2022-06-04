package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

data class JobRow(
    val row: Row,
    val completedCount: Int?,
    val lastWorker: Staff?
)

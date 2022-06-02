package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

data class AssignmentRow(
    val row: JobRow,
    val assigned: Boolean,
    val assignedTreesCount: Int?
)

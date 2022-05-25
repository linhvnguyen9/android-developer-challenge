package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

data class Assignment(
    val staff: Staff,
    val orchard: Orchard,
    val block: String,
    val rateType: RateType,
    val assignmentRow: List<AssignmentRow>
)

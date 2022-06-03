package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

data class Assignment(
    val id: Int,
    val staff: Staff,
    val orchard: Orchard,
    val block: String,
    val rateType: RateType,
    val pieceRate: Double? = null,
    val assignmentRow: List<AssignmentRow>
)

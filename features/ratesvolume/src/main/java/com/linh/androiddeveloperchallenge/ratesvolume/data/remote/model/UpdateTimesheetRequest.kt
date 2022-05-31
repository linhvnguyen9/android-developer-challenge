package com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model

data class UpdateTimesheetRequest(
    val jobs: List<Job>
) {
    data class Job(
        val type: String,
        val assignments: List<Assignment>
    )

    data class Assignment(
        val rateType: String,
        val rate: Double? = null,
        val assignedRows: List<AssignedRow>
    )

    data class AssignedRow(
        val id: Int,
        val assigned: Boolean,
        val assignedTreesCount: Int
    )
}

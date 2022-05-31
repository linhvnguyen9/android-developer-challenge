package com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model

class GetTimesheetResponse(
    val jobs: List<Job>
) {
    data class Job(
        val title: String,
        val jobRow: List<JobRow>,
        val assignments: List<Assignment>
    ) {
        data class JobRow(
            val row: Row,
            val completedCount: Int,
            val lastWorker: Staff
        )

        data class Row(
            val id: Int,
            val num: Int,
            val treeCount: Int
        )

        data class Assignment(
            val id: Int,
            val staff: Staff,
            val orchard: Orchard,
            val block: String,
            val rateType: String,
            val pieceRate: Double? = null,
            val assignmentRow: List<AssignmentRow>
        ) {
            data class Orchard(
                val id: Int,
                val name: String
            )

            data class AssignmentRow(
                val row: JobRow,
                val assigned: Boolean,
                val assignedTreesCount: Int
            ) {
                data class JobRow(
                    val row: Row,
                    val completedCount: Int,
                    val lastWorker: Staff
                )
            }
        }

        data class Staff(
            val firstName: String,
            val lastName: String
        )
    }
}

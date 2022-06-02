package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

data class Job(
    val id: Int,
    val jobType: JobType,
    val jobRow: List<JobRow>,
    val assignments: List<Assignment>
)

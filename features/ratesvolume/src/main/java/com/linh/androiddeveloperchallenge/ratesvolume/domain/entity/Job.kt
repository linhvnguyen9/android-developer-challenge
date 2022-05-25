package com.linh.androiddeveloperchallenge.ratesvolume.domain.entity

data class Job(
    val jobType: JobType,
    val jobRow: List<JobRow>,
    val assignments: List<Assignment>
)

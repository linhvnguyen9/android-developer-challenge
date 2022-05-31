package com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase

import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.JobType
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType
import com.linh.androiddeveloperchallenge.ratesvolume.domain.repository.RatesVolumeRepository
import javax.inject.Inject

class UpdateTimesheetUseCase @Inject constructor(private val repository: RatesVolumeRepository) {
    suspend operator fun invoke(timesheet: Input) = repository.updateTimesheet(timesheet)

    data class Input(
        val jobs: List<JobInput>
    ) {
        data class JobInput(
            val type: JobType,
            val assignments: List<AssignmentInput>
        )

        data class AssignmentInput(
            val rateType: RateType,
            val rate: Double? = null,
            val assignedRows: List<AssignedRowInput>
        )

        data class AssignedRowInput(
            val id: Int,
            val assigned: Boolean,
            val assignedTreesCount: Int
        )
    }
}

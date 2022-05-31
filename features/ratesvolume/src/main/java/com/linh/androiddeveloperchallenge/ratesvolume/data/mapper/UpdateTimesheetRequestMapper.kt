package com.linh.androiddeveloperchallenge.ratesvolume.data.mapper

import com.linh.androiddeveloperchallenge.common.util.BaseMapper
import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.UpdateTimesheetRequest
import com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase.UpdateTimesheetUseCase
import javax.inject.Inject

class UpdateTimesheetRequestMapper @Inject constructor() :
    BaseMapper<UpdateTimesheetUseCase.Input, UpdateTimesheetRequest> {
    override fun map(input: UpdateTimesheetUseCase.Input): UpdateTimesheetRequest {
        return UpdateTimesheetRequest(
            jobs = input.getJobs()
        )
    }

    private fun UpdateTimesheetUseCase.Input.getJobs(): List<UpdateTimesheetRequest.Job> =
        jobs.map { job ->
            UpdateTimesheetRequest.Job(
                type = job.type.name,
                assignments = job.getAssignments()
            )
        }

    private fun UpdateTimesheetUseCase.Input.JobInput.getAssignments(): List<UpdateTimesheetRequest.Assignment> =
        assignments.map { assignment ->
            UpdateTimesheetRequest.Assignment(
                rateType = assignment.rateType.name,
                rate = assignment.rate,
                assignedRows = assignment.getAssignedRows()
            )
        }

    private fun UpdateTimesheetUseCase.Input.AssignmentInput.getAssignedRows(): List<UpdateTimesheetRequest.AssignedRow> =
        assignedRows.map { assignedRow ->
            UpdateTimesheetRequest.AssignedRow(
                id = assignedRow.id,
                assigned = assignedRow.assigned,
                assignedTreesCount = assignedRow.assignedTreesCount
            )
        }
}

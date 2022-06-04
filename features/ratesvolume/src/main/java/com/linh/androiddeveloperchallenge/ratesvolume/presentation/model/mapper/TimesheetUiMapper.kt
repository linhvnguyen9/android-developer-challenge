package com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.mapper

import com.linh.androiddeveloperchallenge.common.util.BaseMapper
import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.*
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUiState
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.utils.getFullName
import javax.inject.Inject

class TimesheetUiMapper @Inject constructor(private val resourceProvider: ResourceProvider) :
    BaseMapper<Timesheet, TimesheetUi> {
    override fun map(input: Timesheet): TimesheetUi {
        return TimesheetUi(
            uiState = TimesheetUiState.Success(
                successUi = TimesheetUi.SuccessUi(jobs = input.getJobs())
            )
        )
    }

    private fun Timesheet.getJobs() = jobs.map { job ->
        TimesheetUi.SuccessUi.JobUi(
            id = job.id,
            title = job.getTitle(),
            type = job.jobType,
            assignments = job.getAssignments()
        )
    }

    private fun Job.getTitle() = when (jobType) {
        JobType.PRUNING -> resourceProvider.getString(R.string.item_job_pruning)
        JobType.THINING -> resourceProvider.getString(R.string.item_job_thining)
    }

    private fun Job.getAssignments() = assignments.map { assignment ->
        TimesheetUi.SuccessUi.JobUi.AssignmentUi(
            id = assignment.id,
            staffUi = assignment.getStaffUi(),
            orchardName = assignment.getOrchardName(),
            blockName = assignment.block,
            selectedRateType = assignment.rateType,
            pieceRate = assignment.pieceRate.toString(),
            rowSelectorUi = assignment.assignmentRow.getRowSelectorUi(),
            rowAssignmentUi = assignment.assignmentRow.getRowAssignmentUi()
        )
    }

    private fun Assignment.getStaffUi() = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
        fullName = staff.getFullName(),
        avatarBackgroundRes = R.drawable.background_avatar
    )
    
    private fun Assignment.getOrchardName() = "${orchard.name} (${orchard.id})"

    private fun List<AssignmentRow>.getRowSelectorUi() = map { assignmentRow ->
        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = assignmentRow.row.row.id,
            num = assignmentRow.row.row.num.toString(),
            state = if (assignmentRow.assigned) {
                if (assignmentRow.row.completedCount != null && assignmentRow.row.completedCount != 0) {
                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                } else {
                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                }
            } else {
                TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
            }
        )
    }

    private fun List<AssignmentRow>.getRowAssignmentUi() = filter { it.assigned }
        .map { assignmentRow ->
            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                rowId = assignmentRow.row.row.id,
                row = resourceProvider.getString(
                    R.string.item_assignment_row,
                    assignmentRow.row.row.id
                ),
                maxCount = assignmentRow.row.row.treeCount,
                assignedCount = assignmentRow.assignedTreesCount,
                previousWorkerName = assignmentRow.row.lastWorker?.getFullName().orEmpty(),
                workedCount = assignmentRow.row.completedCount ?: 0
            )
        }
}

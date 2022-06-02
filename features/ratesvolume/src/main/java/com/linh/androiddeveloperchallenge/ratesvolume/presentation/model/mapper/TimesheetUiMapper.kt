package com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.mapper

import com.linh.androiddeveloperchallenge.common.util.BaseMapper
import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.JobType
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.Timesheet
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUiState
import javax.inject.Inject

class TimesheetUiMapper @Inject constructor(private val resourceProvider: ResourceProvider) :
    BaseMapper<Timesheet, TimesheetUi> {
    override fun map(input: Timesheet): TimesheetUi {
        return TimesheetUi(
            uiState = TimesheetUiState.Success(
                TimesheetUi.SuccessUi(
                    input.jobs.map {
                        TimesheetUi.SuccessUi.JobUi(
                            id = it.id,
                            title = when (it.jobType) {
                                JobType.PRUNING -> resourceProvider.getString(R.string.item_job_pruning)
                                JobType.THINING -> resourceProvider.getString(R.string.item_job_thining)
                            },
                            type = it.jobType,
                            assignments = it.assignments.map { assignment ->
                                TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                    assignment.id,
                                    staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                        "${assignment.staff.firstName} ${assignment.staff.lastName}",
                                        R.drawable.background_avatar
                                    ),
                                    orchardName = "${assignment.orchard.name} (${assignment.orchard.id})",
                                    blockName = assignment.block,
                                    selectedRateType = assignment.rateType,
                                    pieceRate = "", // TODO: Map piece rate
                                    rowSelectorUi = assignment.assignmentRow.map {
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                            it.row.row.id,
                                            it.row.row.num.toString(),
                                            state = if (it.assigned) {
                                                if (it.row.completedCount != 0) {
                                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                                } else {
                                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                                }
                                            } else {
                                                TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
                                            }
                                        )
                                    },
                                    rowAssignmentUi = assignment.assignmentRow.filter { it.assigned }
                                        .map { assignmentRow ->
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                rowId = assignmentRow.row.row.id,
                                                row = resourceProvider.getString(
                                                    R.string.item_assignment_row,
                                                    assignmentRow.row.row.id
                                                ),
                                                maxCount = assignmentRow.row.row.treeCount,
                                                assignedCount = assignmentRow.assignedTreesCount,
                                                previousWorkerName = "${assignmentRow.row.lastWorker.firstName} ${assignmentRow.row.lastWorker.lastName}",
                                                workedCount = assignmentRow.row.completedCount ?: 0
                                            )
                                        }
                                )
                            }
                        )
                    }
                )
            )
        )
    }
}

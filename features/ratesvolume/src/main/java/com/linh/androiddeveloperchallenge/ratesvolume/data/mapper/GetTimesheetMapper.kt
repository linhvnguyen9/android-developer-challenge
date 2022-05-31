package com.linh.androiddeveloperchallenge.ratesvolume.data.mapper

import com.linh.androiddeveloperchallenge.common.util.BaseMapper
import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.GetTimesheetResponse
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.*
import javax.inject.Inject

class GetTimesheetMapper @Inject constructor() : BaseMapper<GetTimesheetResponse, Timesheet> {
    override fun map(input: GetTimesheetResponse): Timesheet {
        return Timesheet(
            input.jobs.map {
                Job(
                    jobType = JobType.from(it.title),
                    jobRow = it.jobRow.map {
                        JobRow(
                            Row(it.row.id, it.row.num, it.row.treeCount),
                            it.completedCount,
                            Staff(it.lastWorker.firstName, it.lastWorker.lastName)
                        )
                    },
                    assignments = it.assignments.map {
                        Assignment(
                            it.id,
                            Staff(it.staff.firstName, it.staff.lastName),
                            Orchard(it.orchard.name, it.orchard.id.toString(), emptyList()),
                            block = it.block,
                            rateType = RateType.from(it.rateType),
                            assignmentRow = it.assignmentRow.map {
                                AssignmentRow(
                                    JobRow(
                                        Row(it.row.row.id, it.row.row.num, it.row.row.treeCount),
                                        it.row.completedCount,
                                        Staff(
                                            it.row.lastWorker.firstName,
                                            it.row.lastWorker.lastName
                                        )
                                    ),
                                    assigned = it.assigned,
                                    assignedTreesCount = it.assignedTreesCount
                                )
                            }
                        )
                    }
                )
            }
        )
    }
}

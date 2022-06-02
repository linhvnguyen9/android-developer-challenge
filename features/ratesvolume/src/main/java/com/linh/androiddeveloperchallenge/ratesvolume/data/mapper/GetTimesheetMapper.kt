package com.linh.androiddeveloperchallenge.ratesvolume.data.mapper

import com.linh.androiddeveloperchallenge.common.util.BaseMapper
import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.GetTimesheetResponse
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.*
import javax.inject.Inject

class GetTimesheetMapper @Inject constructor() : BaseMapper<GetTimesheetResponse, Timesheet> {
    override fun map(input: GetTimesheetResponse): Timesheet {
        return Timesheet(jobs = input.getJobs())
    }

    private fun GetTimesheetResponse.getJobs() = jobs.map {
        Job(
            id = it.id,
            jobType = JobType.from(it.title),
            jobRow = it.getJobRows(),
            assignments = it.getAssignments()
        )
    }

    private fun GetTimesheetResponse.Job.getJobRows() = jobRow.map { jobRow ->
        JobRow(
            row = jobRow.getJobRow(),
            completedCount = jobRow.completedCount,
            lastWorker = jobRow.getStaff()
        )
    }

    private fun GetTimesheetResponse.Job.getAssignments() = assignments.map { assignment ->
        Assignment(
            id = assignment.id,
            staff = assignment.getStaff(),
            orchard = assignment.getOrchard(),
            block = assignment.block,
            rateType = RateType.from(assignment.rateType),
            assignmentRow = assignment.getAssignmentRow()
        )
    }

    private fun GetTimesheetResponse.Job.Assignment.getStaff() =
        Staff(staff.firstName, staff.lastName)

    private fun GetTimesheetResponse.Job.Assignment.getOrchard() =
        Orchard(orchard.name, orchard.id.toString(), emptyList())

    private fun GetTimesheetResponse.Job.JobRow.getJobRow() =
        Row(row.id, row.num, row.treeCount)

    private fun GetTimesheetResponse.Job.JobRow.getStaff() =
        Staff(lastWorker.firstName, lastWorker.lastName)

    private fun GetTimesheetResponse.Job.Assignment.getAssignmentRow() =
        assignmentRow.map { row ->
            AssignmentRow(
                row = row.getRow(),
                assigned = row.assigned,
                assignedTreesCount = row.assignedTreesCount
            )
        }

    private fun GetTimesheetResponse.Job.Assignment.AssignmentRow.getRow() =
        JobRow(
            row = row.getRow(),
            completedCount = row.completedCount,
            lastWorker = getLastWorker()
        )

    private fun GetTimesheetResponse.Job.Assignment.AssignmentRow.getLastWorker() =
        Staff(
            row.lastWorker.firstName,
            row.lastWorker.lastName
        )

    private fun GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow.getRow() =
        Row(row.id, row.num, row.treeCount)
}

package com.linh.androiddeveloperchallenge.ratesvolume.data.remote

import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.GetTimesheetResponse
import kotlinx.coroutines.delay
import javax.inject.Inject

class RatesVolumeServiceMockImpl @Inject constructor() : RatesVolumeService {
    override suspend fun getTimesheet(): GetTimesheetResponse {
        delay(1000)

        return GetTimesheetResponse(
            jobs = listOf(
                GetTimesheetResponse.Job(
                    title = "PRUNING",
                    jobRow = listOf(
                        GetTimesheetResponse.Job.JobRow(
                            row = GetTimesheetResponse.Job.Row(1, 1, 200),
                            completedCount = 100,
                            lastWorker = GetTimesheetResponse.Job.Staff("Li", "Wei")
                        ),
                        GetTimesheetResponse.Job.JobRow(
                            row = GetTimesheetResponse.Job.Row(2, 2, 300),
                            completedCount = 50,
                            lastWorker = GetTimesheetResponse.Job.Staff("Max", "Well")
                        ),
                        GetTimesheetResponse.Job.JobRow(
                            row = GetTimesheetResponse.Job.Row(3, 3, 500),
                            completedCount = 100,
                            lastWorker = GetTimesheetResponse.Job.Staff("Robert", "Miller")
                        )
                    ),
                    assignments = listOf(
                        GetTimesheetResponse.Job.Assignment(
                            id = 1,
                            staff = GetTimesheetResponse.Job.Staff(
                                "Linh",
                                "Nguyen"
                            ),
                            orchard = GetTimesheetResponse.Job.Assignment.Orchard(
                                id = 123123234,
                                name = "Benji"
                            ),
                            block = "23SERSD",
                            rateType = "WAGES",
                            pieceRate = null,
                            assignmentRow = listOf(
                                GetTimesheetResponse.Job.Assignment.AssignmentRow(
                                    row = GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow(
                                        row = GetTimesheetResponse.Job.Row(1, 1, 200),
                                        completedCount = 100,
                                        lastWorker = GetTimesheetResponse.Job.Staff("Li", "Wei")
                                    ),
                                    assigned = true,
                                    assignedTreesCount = 0
                                ),
                                GetTimesheetResponse.Job.Assignment.AssignmentRow(
                                    row = GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow(
                                        row = GetTimesheetResponse.Job.Row(3, 3, 500),
                                        completedCount = 50,
                                        lastWorker = GetTimesheetResponse.Job.Staff("Max", "Well")
                                    ),
                                    assigned = false,
                                    assignedTreesCount = 0
                                )
                            )
                        )
                    )
                ),
                GetTimesheetResponse.Job(
                    title = "THINING",
                    jobRow = listOf(),
                    assignments = listOf(
                        GetTimesheetResponse.Job.Assignment(
                            id = 1,
                            staff = GetTimesheetResponse.Job.Staff(
                                "Linh",
                                "Nguyen"
                            ),
                            orchard = GetTimesheetResponse.Job.Assignment.Orchard(
                                id = 123123234,
                                name = "Benji"
                            ),
                            block = "23SERSD",
                            rateType = "WAGES",
                            pieceRate = null,
                            assignmentRow = listOf(
                                GetTimesheetResponse.Job.Assignment.AssignmentRow(
                                    row = GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow(
                                        row = GetTimesheetResponse.Job.Row(1, 1, 200),
                                        completedCount = 100,
                                        lastWorker = GetTimesheetResponse.Job.Staff("Li", "Wei")
                                    ),
                                    assigned = true,
                                    assignedTreesCount = 0
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}

package com.linh.androiddeveloperchallenge.ratesvolume.data.remote

import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.GetTimesheetResponse
import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.UpdateTimesheetRequest
import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Inject

class RatesVolumeServiceMockImpl @Inject constructor() : RatesVolumeService {
    override suspend fun getTimesheet(): GetTimesheetResponse {
        delay(1000)

        return GetTimesheetResponse(
            jobs = listOf(
                GetTimesheetResponse.Job(
                    id = 1,
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
                        ),
                        GetTimesheetResponse.Job.JobRow(
                            row = GetTimesheetResponse.Job.Row(4, 4, 336),
                            completedCount = null,
                            lastWorker = null
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
                                    assignedTreesCount = null
                                ),
                                GetTimesheetResponse.Job.Assignment.AssignmentRow(
                                    row = GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow(
                                        row = GetTimesheetResponse.Job.Row(3, 3, 500),
                                        completedCount = 100,
                                        lastWorker = GetTimesheetResponse.Job.Staff(
                                            "Robert",
                                            "Miller"
                                        )
                                    ),
                                    assigned = true,
                                    assignedTreesCount = null
                                ),
                                GetTimesheetResponse.Job.Assignment.AssignmentRow(
                                    row = GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow(
                                        row = GetTimesheetResponse.Job.Row(4, 4, 336),
                                        completedCount = null,
                                        lastWorker = null
                                    ),
                                    assigned = true,
                                    assignedTreesCount = null
                                )
                            )
                        ),
                        GetTimesheetResponse.Job.Assignment(
                            id = 2,
                            staff = GetTimesheetResponse.Job.Staff(
                                "Ethan",
                                "Pham"
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
                                    assignedTreesCount = null
                                ),
                                GetTimesheetResponse.Job.Assignment.AssignmentRow(
                                    row = GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow(
                                        row = GetTimesheetResponse.Job.Row(2, 2, 500),
                                        completedCount = 50,
                                        lastWorker = GetTimesheetResponse.Job.Staff("Max", "Well")
                                    ),
                                    assigned = false,
                                    assignedTreesCount = null
                                )
                            )
                        )
                    )
                ),
                GetTimesheetResponse.Job(
                    id = 2,
                    title = "THINING",
                    jobRow = listOf(
                        GetTimesheetResponse.Job.JobRow(
                            row = GetTimesheetResponse.Job.Row(1, 1, 200),
                            completedCount = 100,
                            lastWorker = GetTimesheetResponse.Job.Staff("Li", "Wei")
                        ),
                        GetTimesheetResponse.Job.JobRow(
                            row = GetTimesheetResponse.Job.Row(2, 2, 200),
                            completedCount = null,
                            lastWorker = null
                        )
                    ),
                    assignments = listOf(
                        GetTimesheetResponse.Job.Assignment(
                            id = 3,
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
                                    assignedTreesCount = 50
                                ),
                                GetTimesheetResponse.Job.Assignment.AssignmentRow(
                                    row = GetTimesheetResponse.Job.Assignment.AssignmentRow.JobRow(
                                        row = GetTimesheetResponse.Job.Row(2, 2, 200),
                                        completedCount = null,
                                        lastWorker = null
                                    ),
                                    assigned = true,
                                    assignedTreesCount = 50
                                )
                            )
                        )
                    )
                )
            )
        )
    }

    override suspend fun updateTimesheet(request: UpdateTimesheetRequest) {
        Timber.d(request.toString())
    }
}

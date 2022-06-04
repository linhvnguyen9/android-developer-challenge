package com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.mapper

import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.*
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUiState
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TimesheetUiMapperTest {

    @MockK
    private lateinit var resourceProvider: ResourceProvider

    private lateinit var timesheetUiMapper: TimesheetUiMapper

    private val mockOrchard = Orchard(
        name = "Benji",
        id = "V1394U",
        rows = emptyList()
    )
    private val mockStaff = Staff("Linh", "Nguyen")
    private val mockAssignmentRow = AssignmentRow(
        row = JobRow(
            row = Row(1, 1, 100),
            completedCount = 50,
            lastWorker = Staff("Linh", "Nguyen")
        ),
        assigned = false,
        10
    )
    private val mockAssignment = Assignment(
        id = 1,
        staff = mockStaff,
        orchard = mockOrchard,
        block = "UB13",
        rateType = RateType.PIECE_RATE,
        pieceRate = null,
        assignmentRow = listOf(mockAssignmentRow)
    )
    private val mockJob1 = Job(
        id = 1,
        jobType = JobType.PRUNING,
        jobRow = emptyList(),
        assignments = listOf(mockAssignment)
    )
    private val mockJob2 = Job(
        id = 2,
        jobType = JobType.THINING,
        jobRow = emptyList(),
        assignments = listOf(
            Assignment(
                id = 1,
                staff = mockStaff,
                orchard = mockOrchard,
                block = "UB13",
                rateType = RateType.PIECE_RATE,
                pieceRate = null,
                assignmentRow = listOf(mockAssignmentRow)
            )
        )
    )
    private val mockInput = Timesheet(jobs = listOf(mockJob1, mockJob2))

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        timesheetUiMapper = TimesheetUiMapper(resourceProvider)
    }

    @Test
    fun mapUnassignedRowHasUnselectedRowSelectorState() {
        val assignmentRow = AssignmentRow(
            row = JobRow(
                row = Row(1, 1, 100),
                completedCount = 50,
                lastWorker = Staff("Linh", "Nguyen")
            ),
            assigned = false,
            10
        )
        val input = mockInput.copy(
            jobs = listOf(
                mockJob1.copy(
                    assignments = listOf(
                        mockAssignment.copy(assignmentRow = listOf(assignmentRow))
                    )
                )
            )
        )

        val result = timesheetUiMapper.map(input)
        val resultUi = (result.uiState as TimesheetUiState.Success).successUi

        assertEquals(TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED, resultUi.jobs[0].assignments[0].rowSelectorUi[0].state)
    }

    @Test
    fun mapUnassignedRowHasEmptyRowAssignmentList() {
        val assignmentRow = AssignmentRow(
            row = JobRow(
                row = Row(1, 1, 100),
                completedCount = 50,
                lastWorker = Staff("Linh", "Nguyen")
            ),
            assigned = false,
            10
        )
        val input = mockInput.copy(
            jobs = listOf(
                mockJob1.copy(
                    assignments = listOf(
                        mockAssignment.copy(assignmentRow = listOf(assignmentRow))
                    )
                )
            )
        )

        val result = timesheetUiMapper.map(input)
        val resultUi = (result.uiState as TimesheetUiState.Success).successUi

        assertEquals(true, resultUi.jobs[0].assignments[0].rowAssignmentUi.isEmpty())
    }

    @Test
    fun mapAssignedButNotWorkedRowHasSelectedRowSelectorState() {
        val assignmentRow = AssignmentRow(
            row = JobRow(
                row = Row(1, 1, 100),
                completedCount = null,
                lastWorker = null
            ),
            assigned = true,
            10
        )
        val input = mockInput.copy(
            jobs = listOf(
                mockJob1.copy(
                    assignments = listOf(
                        mockAssignment.copy(assignmentRow = listOf(assignmentRow))
                    )
                )
            )
        )

        val result = timesheetUiMapper.map(input)
        val resultUi = (result.uiState as TimesheetUiState.Success).successUi

        assertEquals(TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED, resultUi.jobs[0].assignments[0].rowSelectorUi[0].state)
    }

    @Test
    fun mapAssignedAndWorkedRowHasSelectedWorkedRowSelectorState() {
        val assignmentRow = AssignmentRow(
            row = JobRow(
                row = Row(1, 1, 100),
                completedCount = 10,
                lastWorker = Staff("Linh", "Nguyen")
            ),
            assigned = true,
            10
        )
        val input = mockInput.copy(
            jobs = listOf(
                mockJob1.copy(
                    assignments = listOf(
                        mockAssignment.copy(assignmentRow = listOf(assignmentRow))
                    )
                )
            )
        )

        val result = timesheetUiMapper.map(input)
        val resultUi = (result.uiState as TimesheetUiState.Success).successUi

        assertEquals(TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED, resultUi.jobs[0].assignments[0].rowSelectorUi[0].state)
    }
}

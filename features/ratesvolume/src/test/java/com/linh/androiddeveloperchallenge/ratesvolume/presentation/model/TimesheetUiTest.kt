package com.linh.androiddeveloperchallenge.ratesvolume.presentation.model

import org.junit.Assert.*
import org.junit.Test
import com.linh.androiddeveloperchallenge.ratesvolume.R

class TimesheetUiTest {

    @Test
    fun getInitialsForNameWithFirstAndLastNameReturnsFirstCharacters() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi("Linh Nguyen")

        assertEquals("LN", (input.initials))
    }

    @Test
    fun getInitialsForNameWithSingleWordNameReturnsFirstCharacter() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi("Linh")

        assertEquals("L", (input.initials))
    }

    @Test
    fun getInitialsForNameWithSpaceReturnsTrimmedFirstCharacter() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi("    Linh   Nguyen     ")

        assertEquals("LN", (input.initials))
    }

    @Test
    fun getIsSelectedForSelectedRowReturnsTrue() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
        )

        assertEquals(true, input.isSelected)
    }

    @Test
    fun getIsSelectedForSelectedWorkedRowReturnsTrue() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
        )

        assertEquals(true, input.isSelected)
    }

    @Test
    fun getIsSelectedForUnselectedRowReturnsFalse() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
        )

        assertEquals(false, input.isSelected)
    }

    @Test
    fun getTextColorForSelectedRowReturnsWhite() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
        )

        assertEquals(android.R.color.white, input.textColorRes)
    }

    @Test
    fun getTextColorForSelectedWorkedRowReturnsWhite() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
        )

        assertEquals(android.R.color.white, input.textColorRes)
    }

    @Test
    fun getTextColorForUnselectedRowReturnsBlack() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
        )

        assertEquals(android.R.color.black, input.textColorRes)
    }

    @Test
    fun getBackgroundColorForSelectedRowReturnsSelectedBackground() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
        )

        assertEquals(R.drawable.background_row_selected, input.backgroundRes)
    }

    @Test
    fun getBackgroundColorForSelectedWorkedRowReturnsSelectedBackground() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
        )

        assertEquals(R.drawable.background_row_selected, input.backgroundRes)
    }

    @Test
    fun getBackgroundColorForUnselectedRowReturnsUnselectedBackground() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
        )

        assertEquals(R.drawable.background_row_unselected, input.backgroundRes)
    }

    @Test
    fun hideIndicatorForSelectedRow() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
        )

        assertEquals(false, input.shouldShowIndicator)
    }

    @Test
    fun showIndicatorForSelectedWorkedRow() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
        )

        assertEquals(true, input.shouldShowIndicator)
    }

    @Test
    fun hideIndicatorForUnselectedRow() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
            id = 1,
            num = "1",
            state = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
        )

        assertEquals(false, input.shouldShowIndicator)
    }

    @Test
    fun hidePreviousWorkerTextIfWorkedCountIsZero() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
            rowId = 1,
            row = "Row",
            maxCount = 1234,
            assignedCount = 0,
            previousWorkerName = "",
            workedCount = 0
        )

        assertEquals(false, input.isPreviousWorkerVisible)
    }

    @Test
    fun showPreviousWorkerTextIfWorkedCountIsNotZeroOrNull() {
        val input = TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
            rowId = 1,
            row = "Row",
            maxCount = 1234,
            assignedCount = null,
            previousWorkerName = "Linh",
            workedCount = 10
        )

        assertEquals(true, input.isPreviousWorkerVisible)
    }
}

package com.linh.androiddeveloperchallenge.ratesvolume.presentation.model

import androidx.annotation.DrawableRes
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType

data class TimesheetUi(
    val uiState: TimesheetUiState = TimesheetUiState.Loading
) {
    data class SuccessUi(
        val jobs: List<JobUi>
    ) {
        data class JobUi(
            val title: String,
            val assignments: List<AssignmentUi>
        ) {
            data class AssignmentUi(
                val id: Int,
                val staffUi: StaffUi,
                val orchardName: String,
                val blockName: String,
                val selectedRateType: RateType,
                val pieceRate: String,
                val rowSelectorUi: List<RowSelectorUi>,
                val rowAssignmentUi: List<RowAssignmentUi>
            ) {
                val isRateTypeWagesSelected get() = selectedRateType == RateType.Wages
                val isRateTypePieceRateSelected get() = selectedRateType is RateType.PieceRate

                data class StaffUi(
                    val fullName: String,
                    @DrawableRes val avatarBackgroundRes: Int
                ) {
                    val initials get() = fullName.split(" ").joinToString(separator = "") { it.first().toString() }
                }

                data class RowSelectorUi(
                    val id: Int,
                    val num: String,
                    val state: RowSelectorState
                ) {
                    val isSelected get() = state == RowSelectorState.SELECTED || state == RowSelectorState.SELECTED_WORKED

                    val backgroundRes
                        get() = when (state) {
                            RowSelectorState.UNSELECTED -> R.drawable.background_row_unselected
                            RowSelectorState.SELECTED, RowSelectorState.SELECTED_WORKED -> R.drawable.background_row_selected
                        }

                    val textColorRes
                        get() = when (state) {
                            RowSelectorState.UNSELECTED -> android.R.color.black
                            RowSelectorState.SELECTED, RowSelectorState.SELECTED_WORKED -> android.R.color.white
                        }

                    val shouldShowIndicator get() = state == RowSelectorState.SELECTED_WORKED
                }

                enum class RowSelectorState {
                    UNSELECTED,
                    SELECTED,
                    SELECTED_WORKED
                }

                data class RowAssignmentUi(
                    val rowId: Int,
                    val row: String,
                    val maxCount: Int,
                    val assignedCount: Int? = null,
                    val previousWorker: String
                )
            }
        }
    }
}

sealed class TimesheetUiState {
    object Loading : TimesheetUiState()
    object Error : TimesheetUiState()
    data class Success(val successUi: TimesheetUi.SuccessUi) : TimesheetUiState()
}

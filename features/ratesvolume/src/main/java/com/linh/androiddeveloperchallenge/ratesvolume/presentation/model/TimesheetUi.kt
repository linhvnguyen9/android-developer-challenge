package com.linh.androiddeveloperchallenge.ratesvolume.presentation.model

import androidx.annotation.DrawableRes
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.JobType
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType

data class TimesheetUi(
    val uiState: TimesheetUiState = TimesheetUiState.Loading
) {
    data class SuccessUi(
        val jobs: List<JobUi>
    ) {
        data class JobUi(
            val id: Int,
            val title: String,
            val type: JobType,
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
                val isRateTypeWagesSelected get() = selectedRateType == RateType.WAGES
                val isRateTypePieceRateSelected get() = selectedRateType == RateType.PIECE_RATE

                data class StaffUi(
                    val fullName: String,
                    @DrawableRes val avatarBackgroundRes: Int = R.drawable.background_avatar
                ) {
                    val initials: String
                        get() {
                            val nameElements: List<String> = fullName
                                .replace("\\s+".toRegex(), " ")
                                .trim()
                                .split(" ")

                            return if (nameElements.size == 1) {
                                fullName.first().toString()
                            } else {
                                nameElements.joinToString(separator = "") {
                                    it.first().toString()
                                }
                            }
                        }
                }

                data class RowSelectorUi(
                    val id: Int,
                    val num: String,
                    val state: RowSelectorState
                ) {
                    val isSelected get() = state == RowSelectorState.SELECTED || state == RowSelectorState.SELECTED_WORKED

                    val backgroundRes
                        get() = if (isSelected) R.drawable.background_row_selected else R.drawable.background_row_unselected

                    val textColorRes
                        get() = if (isSelected) android.R.color.white else android.R.color.black

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
                    val previousWorkerName: String,
                    val workedCount: Int
                ) {
                    val previousWorker get() = "$previousWorkerName ($workedCount)"
                    val isPreviousWorkerVisible = previousWorker.isNotBlank() && workedCount != 0
                    val assignedCountText = assignedCount?.toString()
                    val maxCountLabel get() = "/ $maxCount"
                }
            }
        }
    }
}

sealed class TimesheetUiState {
    object Loading : TimesheetUiState()
    object Error : TimesheetUiState()
    data class Success(val successUi: TimesheetUi.SuccessUi) : TimesheetUiState()
}

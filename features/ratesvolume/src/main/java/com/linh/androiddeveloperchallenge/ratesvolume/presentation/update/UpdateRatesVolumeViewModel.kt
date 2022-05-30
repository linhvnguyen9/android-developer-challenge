package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.linh.androiddeveloperchallenge.common.base.BaseViewModel
import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateRatesVolumeViewModel @Inject constructor(
    resourceProvider: ResourceProvider
) : BaseViewModel() {
    private val _uiModel = MutableLiveData<TimesheetUi>()
    val uiModel: LiveData<TimesheetUi> get() = _uiModel

    private val mockData = TimesheetUi(
        TimesheetUiState.Success(
            TimesheetUi.SuccessUi(
                listOf(
                    TimesheetUi.SuccessUi.JobUi(
                        title = "Pruning",
                        listOf(
                            TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                id = 1,
                                staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                    "Linh Nguyen",
                                    R.drawable.background_avatar
                                ),
                                orchardName = "Benji (123123234)",
                                blockName = "23SERSD",
                                selectedRateType = RateType.Wages,
                                pieceRate = "",
                                rowSelectorUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
                                    )
                                ),
                                rowAssignmentUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    )
                                )
                            ),
                            TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                id = 2,
                                staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                    "Linh Nguyen",
                                    R.drawable.background_avatar
                                ),
                                orchardName = "Benji (123123234)",
                                blockName = "23SERSD",
                                selectedRateType = RateType.Wages,
                                pieceRate = "",
                                rowSelectorUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
                                    )
                                ),
                                rowAssignmentUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    )
                                )
                            ),
                            TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                id = 3,
                                staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                    "Linh Nguyen",
                                    R.drawable.background_avatar
                                ),
                                orchardName = "Benji (123123234)",
                                blockName = "23SERSD",
                                selectedRateType = RateType.PieceRate(234234.34),
                                pieceRate = "234234.34",
                                rowSelectorUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
                                    )
                                ),
                                rowAssignmentUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        resourceProvider.getString(R.string.item_assignment_row, 3),
                                        435,
                                        123,
                                        resourceProvider.getString(
                                            R.string.item_assignment_row_previous_worker,
                                            "Test",
                                            123
                                        )
                                    )
                                )
                            )
                        )
                    ),
                    TimesheetUi.SuccessUi.JobUi(
                        title = "Pruning",
                        listOf(
                            TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                id = 4,
                                staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                    "Linh Nguyen",
                                    R.drawable.background_avatar
                                ),
                                orchardName = "Benji (123123234)",
                                blockName = "23SERSD",
                                selectedRateType = RateType.Wages,
                                pieceRate = "",
                                rowSelectorUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
                                    )
                                ),
                                rowAssignmentUi = listOf()
                            )
                        )
                    )
                )
            )
        )
    )

    init {
        fetchData()
    }

    fun updateRateType(assignmentId: Int, rateType: RateType) {
        updateAssignment(assignmentId) { oldAssignment ->
            oldAssignment.copy(selectedRateType = rateType)
        }
    }

    fun updatePieceRate(assignmentId: Int, rate: String) {
        updateAssignment(assignmentId) { oldAssignment ->
            oldAssignment.copy(pieceRate = rate)
        }
    }

    private fun updateAssignment(
        assignmentId: Int,
        onUpdate: (oldAssignment: TimesheetUi.SuccessUi.JobUi.AssignmentUi) -> TimesheetUi.SuccessUi.JobUi.AssignmentUi
    ) {
        (_uiModel.value?.uiState as? TimesheetUiState.Success)?.let { oldState ->
            val jobs = oldState.successUi.jobs.toMutableList()
            val updatedJob = jobs.find { it.assignments.find { assignmentId == it.id } != null }
            val oldAssignmentIndex = updatedJob?.assignments?.indexOfFirst { it.id == assignmentId }
            oldAssignmentIndex?.let {
                val assignments = updatedJob.assignments.toMutableList()
                assignments[oldAssignmentIndex] =
                    onUpdate(updatedJob.assignments[oldAssignmentIndex])
                val updatedJobIndex =
                    jobs.indexOfFirst { it.assignments.find { assignmentId == it.id } != null }
                jobs[updatedJobIndex] = updatedJob.copy(assignments = assignments.toList())

                _uiModel.value = _uiModel.value?.copy(
                    uiState = oldState.copy(
                        successUi = oldState.successUi.copy(jobs = jobs)
                    )
                )
            }
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            _uiModel.value = mockData
        }
    }
}

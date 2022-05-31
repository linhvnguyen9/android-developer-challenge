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
    private val resourceProvider: ResourceProvider
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
                                        1,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        2,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        3,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        4,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    )
                                ),
                                rowAssignmentUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        1,
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
                                        2,
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
                                        3,
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
                                        4,
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
                                        1,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        2,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        3,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        4,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    )
                                ),
                                rowAssignmentUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        1,
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
                                        2,
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
                                        3,
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
                                        4,
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
                                        1,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        2,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        3,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        4,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        5,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        6,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    )
                                ),
                                rowAssignmentUi = listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                        1,
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
                                        2,
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
                                        3,
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
                                        4,
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
                                        5,
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
                                        6,
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
                                        1,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        2,
                                        "3",
                                        TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED_WORKED
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorUi(
                                        3,
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

    fun toggleAssignRow(assignmentId: Int, rowId: Int) {
        updateAssignment(assignmentId) { oldAssignment ->
            val selector = oldAssignment.rowSelectorUi.toMutableList()
            val rowAssignment = oldAssignment.rowAssignmentUi.toMutableList()

            val rowToUpdateIndex = selector.indexOfFirst { it.id == rowId }
            val rowToUpdate = selector[rowToUpdateIndex]

            val rowAssignmentToUpdateIndex = rowAssignment.indexOfFirst { it.rowId == rowId }

            val updatedState = if (rowToUpdate.isSelected) {
                rowAssignment.removeAt(rowAssignmentToUpdateIndex)
                TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.UNSELECTED
            } else {
                rowAssignment.add(TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(rowId, resourceProvider.getString(R.string.item_assignment_row, rowId), 250, null, "")) // TODO: get info from data loaded from API instead of UiState
                TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowSelectorState.SELECTED
            }
            selector[rowToUpdateIndex] = rowToUpdate.copy(state = updatedState)
            oldAssignment.copy(rowSelectorUi = selector, rowAssignmentUi = rowAssignment.sortedBy { it.rowId })
        }
    }

    fun applyRateToAll(assignmentId: Int) {
        (_uiModel.value?.uiState as? TimesheetUiState.Success)?.let { oldState ->
            val jobs = oldState.successUi.jobs.toMutableList()
            val updatedJob = jobs.find { it.assignments.find { assignmentId == it.id } != null }
            val oldAssignmentIndex = updatedJob?.assignments?.indexOfFirst { it.id == assignmentId }
            oldAssignmentIndex?.let {
                val assignments = updatedJob.assignments.toMutableList()
                val currentAssignment = updatedJob.assignments[oldAssignmentIndex]
                val updatedAssignments = assignments.map { if (it.isRateTypePieceRateSelected) it.copy(pieceRate = currentAssignment.pieceRate) else it }
                val updatedJobIndex =
                    jobs.indexOfFirst { it.assignments.find { assignmentId == it.id } != null }
                jobs[updatedJobIndex] = updatedJob.copy(assignments = updatedAssignments)

                _uiModel.value = _uiModel.value?.copy(
                    uiState = oldState.copy(
                        successUi = oldState.successUi.copy(jobs = jobs)
                    )
                )
            }
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

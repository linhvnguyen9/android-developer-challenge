package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.linh.androiddeveloperchallenge.common.base.BaseViewModel
import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.Timesheet
import com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase.GetTimesheetUseCase
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUiState
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.mapper.TimesheetUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateRatesVolumeViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val getTimesheetUseCase: GetTimesheetUseCase,
    private val timesheetMapper: TimesheetUiMapper
) : BaseViewModel() {
    private val responseModel = MutableLiveData<Timesheet>()

    private val _uiModel = MediatorLiveData<TimesheetUi>()
    val uiModel: LiveData<TimesheetUi> get() = _uiModel

    init {
        _uiModel.addSource(responseModel) {
            _uiModel.value = it.run(timesheetMapper::map)
        }

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
                val responseJob =
                    responseModel.value?.jobs?.find { it.assignments.find { it.id == assignmentId } != null }
                val responseRow = responseJob?.jobRow?.find { it.row.id == rowId }
                rowAssignment.add(
                    TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                        rowId,
                        resourceProvider.getString(R.string.item_assignment_row, rowId),
                        maxCount = responseRow?.row?.treeCount ?: 0,
                        assignedCount = responseRow?.completedCount,
                        previousWorker = "${responseRow?.lastWorker?.firstName} ${responseRow?.lastWorker?.lastName} (${responseRow?.completedCount})"
                    )
                )
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

    fun updateRowAssignment(assignmentId: Int, rowId: Int, treesToAssign: Int) {
        updateAssignment(assignmentId) { oldAssignment ->
            val rowAssignments = oldAssignment.rowAssignmentUi.toMutableList()
            val rowToUpdateIndex = rowAssignments.indexOfFirst { it.rowId == rowId }
            val rowToUpdate = rowAssignments[rowToUpdateIndex]

            rowAssignments[rowToUpdateIndex] = rowToUpdate.copy(assignedCount = treesToAssign)
            oldAssignment.copy(rowAssignmentUi = rowAssignments.sortedBy { it.rowId })
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            responseModel.value = getTimesheetUseCase()
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
}

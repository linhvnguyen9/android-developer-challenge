package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.linh.androiddeveloperchallenge.common.base.BaseViewModel
import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.*
import com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase.GetTimesheetUseCase
import com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase.UpdateTimesheetUseCase
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
    private val updateTimesheetUseCase: UpdateTimesheetUseCase,
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

    fun addMaxTreesToAssignments(jobId: Int) {
        (_uiModel.value?.uiState as? TimesheetUiState.Success)?.let { oldState ->
            val jobs = oldState.successUi.jobs.toMutableList()
            val updatedJobIndex = jobs.indexOfFirst { it.id == jobId }

            if (updatedJobIndex == -1) return

            val updatedJob = jobs[updatedJobIndex]

            val jobRows = responseModel.value?.jobs?.find { it.id == jobId }?.jobRow ?: emptyList()

            jobRows.forEach { jobRow ->
                val remainingTrees = jobRow.row.treeCount - jobRow.completedCount
                val usersWithRowAssigned =
                    updatedJob.assignments.count { it.rowAssignmentUi.find { it.rowId == jobRow.row.id } != null }

                if (usersWithRowAssigned != 0) {
                    val treesPerUser = remainingTrees / usersWithRowAssigned

                    val assignments = jobs[updatedJobIndex].assignments.map { assignmentUi ->
                        assignmentUi.copy(
                            rowAssignmentUi = assignmentUi.rowAssignmentUi.map { rowAssignmentUi ->
                                if (rowAssignmentUi.rowId == jobRow.row.id) {
                                    rowAssignmentUi.copy(assignedCount = treesPerUser)
                                } else {
                                    rowAssignmentUi
                                }
                            }
                        )
                    }

                    jobs[updatedJobIndex] = jobs[updatedJobIndex].copy(assignments = assignments)
                }
            }

            _uiModel.value = _uiModel.value?.copy(
                uiState = oldState.copy(
                    successUi = oldState.successUi.copy(jobs = jobs)
                )
            )
        }
    }

    fun updateRowAssignment(assignmentId: Int, rowId: Int, treesToAssign: Int?) {
        updateAssignment(assignmentId) { oldAssignment ->
            val rowAssignments = oldAssignment.rowAssignmentUi.toMutableList()
            val rowToUpdateIndex = rowAssignments.indexOfFirst { it.rowId == rowId }

            if (rowToUpdateIndex != -1) {
                val rowToUpdate = rowAssignments[rowToUpdateIndex]

                rowAssignments[rowToUpdateIndex] =
                    rowToUpdate.copy(assignedCount = treesToAssign)
                // TODO: Check for trees assigned in the same row in other assignments, and previously completed trees
                oldAssignment.copy(rowAssignmentUi = rowAssignments.sortedBy { it.rowId })
            } else {
                oldAssignment
            }
        }
    }

    fun submitData() {
        viewModelScope.launch {
            val state = (_uiModel.value?.uiState as? TimesheetUiState.Success)?.successUi

            state?.let {
                updateTimesheetUseCase(
                    UpdateTimesheetUseCase.Input(
                        it.jobs.map { job ->
                            UpdateTimesheetUseCase.Input.JobInput(
                                job.type,
                                job.assignments.map { assignment ->
                                    UpdateTimesheetUseCase.Input.AssignmentInput(
                                        assignment.selectedRateType,
                                        assignment.pieceRate.toDoubleOrNull(),
                                        assignment.rowSelectorUi.map { row ->
                                            UpdateTimesheetUseCase.Input.AssignedRowInput(
                                                row.id,
                                                row.isSelected,
                                                assignment.rowAssignmentUi.find { it.rowId == row.id }?.assignedCount
                                                    ?: 0
                                            )
                                        }
                                    )
                                }
                            )
                        }
                    )
                )
            }
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            responseModel.value = getTimesheetUseCase() // TODO: Handle API errors
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

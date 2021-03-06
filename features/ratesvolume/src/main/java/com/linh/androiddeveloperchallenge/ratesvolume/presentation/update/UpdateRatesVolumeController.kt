package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import com.airbnb.epoxy.*
import com.linh.androiddeveloperchallenge.ratesvolume.*
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUiState
import javax.inject.Inject

class UpdateRatesVolumeController @Inject constructor() : TypedEpoxyController<TimesheetUi>() {
    private lateinit var listener: UpdateRatesVolumeListener

    fun setupListener(listener: UpdateRatesVolumeListener) {
        this.listener = listener
    }

    override fun buildModels(data: TimesheetUi) {
        when (data.uiState) {
            is TimesheetUiState.Loading -> {
                // TODO: Show some kind of loading screen/ skeleton state
            }
            is TimesheetUiState.Success -> createItems(data.uiState.successUi.jobs)
            is TimesheetUiState.Error -> {
                // TODO: Show some kind of error message
            }
        }
    }

    private fun createItems(items: List<TimesheetUi.SuccessUi.JobUi>) {
        items.forEachIndexed { index, job ->
            group {
                id("$index-group")
                layout(R.layout.item_job)

                jobHeader {
                    id("$index-jobHeader")
                    jobName(job.title)
                    onClickAddMaxTrees { _ ->
                        this@UpdateRatesVolumeController.listener.onClickAddMaxTrees(
                            job.id
                        )
                    }
                }

                val assignmentsItems = job.assignments.mapIndexed { index, assignmentUi ->
                    val assignmentDetailModel = AssignmentDetailBindingModel_()
                        .id("$index-assignmentDetail")
                        .jobName(job.title)
                        .assignmentUi(assignmentUi)
                        .onClickPieceRate { _ -> this@UpdateRatesVolumeController.listener.onClickRateType(assignmentUi.id, rateType = RateType.PIECE_RATE) }
                        .onClickWages { _ -> this@UpdateRatesVolumeController.listener.onClickRateType(assignmentUi.id, rateType = RateType.WAGES) }
                        .onRateChange { s, _, _, _ -> this@UpdateRatesVolumeController.listener.onRateChange(assignmentUi.id, s.toString()) }
                        .onClickApplyToAll { _ -> this@UpdateRatesVolumeController.listener.onClickApplyToAll(assignmentUi.id) }

                    val rowSelectCarouselItems =
                        assignmentUi.rowSelectorUi.mapIndexed { index, rowSelectorUi ->
                            AssignmentRowBindingModel_()
                                .id("$index-assignmentRow")
                                .rowSelectorUi(rowSelectorUi)
                                .onClick { _ -> this@UpdateRatesVolumeController.listener.onClickRowSelector(assignmentUi.id, rowSelectorUi.id) }
                        }

                    val rowAssignCarouselItems =
                        assignmentUi.rowAssignmentUi.mapIndexed { index, rowAssignmentUi ->
                            AssignmentRowInfoBindingModel_()
                                .id("$index-assignmentRowInfo")
                                .assignmentRow(rowAssignmentUi)
                                .onAssignmentChange { s, _, _, _ ->
                                    this@UpdateRatesVolumeController.listener.onRowAssignmentChange(
                                        jobId = job.id,
                                        assignmentId = assignmentUi.id,
                                        rowId = rowAssignmentUi.rowId,
                                        treesToAssign = s.toString().toIntOrNull()
                                    )
                                }
                        }

                    val rowSelectCarouselModel = CarouselModel_()
                        .id("$index-row-select-carousel")
                        .models(rowSelectCarouselItems)
                        .paddingRes(R.dimen.padding_assignment_row)

                    val rowAssignCarouselModel = VerticalCarouselModel_()
                        .id("$index-row-assign-carousel")
                        .models(rowAssignCarouselItems)
                        .paddingRes(R.dimen.padding_assignment_row)

                    EpoxyModelGroup(
                        R.layout.item_assignment,
                        listOf(
                            assignmentDetailModel,
                            rowSelectCarouselModel,
                            rowAssignCarouselModel
                        )
                    )
                }

                verticalCarousel {
                    id("$index-assignment")
                    models(assignmentsItems)
                    paddingRes(R.dimen.padding_assignment_row)
                }
            }
        }

        confirm {
            id("confirm")
            onClick { _ -> this@UpdateRatesVolumeController.listener.onClickConfirm() }
        }
    }
}

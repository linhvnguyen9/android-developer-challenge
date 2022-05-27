package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import com.airbnb.epoxy.*
import com.linh.androiddeveloperchallenge.ratesvolume.*
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
                }

                val assignmentsItems = job.assignments.mapIndexed { index, assignmentUi ->
                    val assignmentDetailModel = AssignmentDetailBindingModel_()
                        .id("$index-assignmentDetail")
                        .assignmentUi(assignmentUi)

                    val rowSelectCarouselItems =
                        assignmentUi.rowSelectorUi.mapIndexed { index, rowSelectorUi ->
                            AssignmentRowBindingModel_()
                                .id("$index-assignmentRow")
                                .rowSelectorUi(rowSelectorUi)
                        }

                    val rowAssignCarouselItems =
                        assignmentUi.rowAssignmentUi.mapIndexed { index, rowAssignmentUi ->
                            AssignmentRowInfoBindingModel_()
                                .id("$index-assignmentRowInfo")
                                .assignmentRow(rowAssignmentUi)
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
    }
}

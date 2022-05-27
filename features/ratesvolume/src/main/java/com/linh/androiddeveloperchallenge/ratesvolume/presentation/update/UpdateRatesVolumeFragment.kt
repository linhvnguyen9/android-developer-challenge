package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import androidx.fragment.app.viewModels
import com.linh.androiddeveloperchallenge.common.base.BaseFragment
import com.linh.androiddeveloperchallenge.ratesvolume.BR
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.databinding.FragmentUpdateRatesVolumeBinding
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UpdateRatesVolumeFragment :
    BaseFragment<UpdateRatesVolumeViewModel, FragmentUpdateRatesVolumeBinding>(),
    UpdateRatesVolumeListener {
    @Inject
    lateinit var controller: UpdateRatesVolumeController

    override val viewModel: UpdateRatesVolumeViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_update_rates_volume

    override fun getViewModelBindingVariable() = BR.viewModel

    override fun initView() {
        initRecyclerViewController()
    }

    private fun initRecyclerViewController() {
        binding.epoxyRecyclerViewUpdateRatesVolume.apply {
            controller.setupListener(this@UpdateRatesVolumeFragment)
            setController(controller)
        }
    }

    override fun initViewModel() {
        controller.setData(
            TimesheetUi(
                TimesheetUiState.Success(
                    TimesheetUi.SuccessUi(
                        listOf(
                            TimesheetUi.SuccessUi.JobUi(
                                title = "Pruning",
                                listOf(
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                        staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                            "Linh Nguyen",
                                            R.drawable.background_avatar
                                        ),
                                        orchardName = "Benji (123123234)",
                                        blockName = "23SERSD",
                                        selectedRateType = RateType.PieceRate(234234.34),
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
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            )
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                        staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                            "Linh Nguyen",
                                            R.drawable.background_avatar
                                        ),
                                        orchardName = "Benji (123123234)",
                                        blockName = "23SERSD",
                                        selectedRateType = RateType.PieceRate(234234.34),
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
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            )
                                        )
                                    ),
                                    TimesheetUi.SuccessUi.JobUi.AssignmentUi(
                                        staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                            "Linh Nguyen",
                                            R.drawable.background_avatar
                                        ),
                                        orchardName = "Benji (123123234)",
                                        blockName = "23SERSD",
                                        selectedRateType = RateType.PieceRate(234234.34),
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
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
                                                    R.string.item_assignment_row_previous_worker,
                                                    "Test",
                                                    123
                                                )
                                            ),
                                            TimesheetUi.SuccessUi.JobUi.AssignmentUi.RowAssignmentUi(
                                                getString(R.string.item_assignment_row, 3),
                                                435,
                                                123,
                                                getString(
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
                                        staffUi = TimesheetUi.SuccessUi.JobUi.AssignmentUi.StaffUi(
                                            "Linh Nguyen",
                                            R.drawable.background_avatar
                                        ),
                                        orchardName = "Benji (123123234)",
                                        blockName = "23SERSD",
                                        selectedRateType = RateType.PieceRate(234234.34),
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
        )
    }
}

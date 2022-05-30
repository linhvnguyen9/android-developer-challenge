package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import androidx.fragment.app.viewModels
import com.linh.androiddeveloperchallenge.common.base.BaseFragment
import com.linh.androiddeveloperchallenge.ratesvolume.BR
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.databinding.FragmentUpdateRatesVolumeBinding
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi
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
        observeData()
    }

    override fun onClickRateType(assignmentId: Int, rateType: RateType) {
        viewModel.updateRateType(assignmentId, rateType)
    }

    override fun onRateChange(assignmentId: Int, rate: String) {
        viewModel.updatePieceRate(assignmentId, rate)
    }

    private fun observeData() {
        viewModel.uiModel.observe(viewLifecycleOwner) {
            controller.setData(it)
        }
    }
}

package com.linh.androiddeveloperchallenge.ratesvolume.presentation

import androidx.fragment.app.viewModels
import com.linh.androiddeveloperchallenge.common.base.BaseFragment
import com.linh.androiddeveloperchallenge.ratesvolume.BR
import com.linh.androiddeveloperchallenge.ratesvolume.R
import com.linh.androiddeveloperchallenge.ratesvolume.databinding.FragmentUpdateRatesVolumeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateRatesVolumeFragment : BaseFragment<UpdateRatesVolumeViewModel, FragmentUpdateRatesVolumeBinding>() {
    override val viewModel: UpdateRatesVolumeViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_update_rates_volume

    override fun getViewModelBindingVariable() = BR.viewModel

    override fun initView() {
    }

    override fun initViewModel() {
    }
}

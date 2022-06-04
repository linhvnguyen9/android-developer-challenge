package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase.GetTimesheetUseCase
import com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase.UpdateTimesheetUseCase
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.mapper.TimesheetUiMapper
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.update.UpdateRatesVolumeViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UpdateRatesVolumeViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: UpdateRatesVolumeViewModel

    @MockK
    private lateinit var resourceProvider: ResourceProvider

    @MockK
    private lateinit var getTimesheetUseCase: GetTimesheetUseCase

    @MockK
    private lateinit var updateTimesheetUseCase: UpdateTimesheetUseCase

    @MockK
    private lateinit var timesheetMapper: TimesheetUiMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        viewModel = UpdateRatesVolumeViewModel(resourceProvider, getTimesheetUseCase, updateTimesheetUseCase, timesheetMapper)
    }

    @Test
    fun test() {

    }
}
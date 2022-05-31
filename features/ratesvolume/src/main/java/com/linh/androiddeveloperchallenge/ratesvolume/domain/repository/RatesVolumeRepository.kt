package com.linh.androiddeveloperchallenge.ratesvolume.domain.repository

import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.Timesheet
import com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase.UpdateTimesheetUseCase

interface RatesVolumeRepository {
    suspend fun getTimesheet(): Timesheet
    suspend fun updateTimesheet(timesheet: UpdateTimesheetUseCase.Input)
}

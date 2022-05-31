package com.linh.androiddeveloperchallenge.ratesvolume.domain.repository

import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.Timesheet

interface RatesVolumeRepository {
    suspend fun getTimesheet(): Timesheet
    suspend fun updateTimesheet(timesheet: Timesheet)
}
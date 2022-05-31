package com.linh.androiddeveloperchallenge.ratesvolume.data.repository

import com.linh.androiddeveloperchallenge.ratesvolume.data.mapper.GetTimesheetMapper
import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.RatesVolumeService
import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.Timesheet
import com.linh.androiddeveloperchallenge.ratesvolume.domain.repository.RatesVolumeRepository
import javax.inject.Inject

class RatesVolumeRepositoryImpl @Inject constructor(
    private val getTimesheetMapper: GetTimesheetMapper,
    private val ratesVolumeService: RatesVolumeService
) : RatesVolumeRepository {
    override suspend fun getTimesheet(): Timesheet =
        ratesVolumeService.getTimesheet().run(getTimesheetMapper::map)

    override suspend fun updateTimesheet(timesheet: Timesheet) {
        TODO("Not yet implemented")
    }
}

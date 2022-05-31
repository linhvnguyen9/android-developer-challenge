package com.linh.androiddeveloperchallenge.ratesvolume.data.remote

import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.GetTimesheetResponse
import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.UpdateTimesheetRequest

interface RatesVolumeService {
    suspend fun getTimesheet(): GetTimesheetResponse
    suspend fun updateTimesheet(request: UpdateTimesheetRequest)
}

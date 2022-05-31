package com.linh.androiddeveloperchallenge.ratesvolume.data.remote

import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.model.GetTimesheetResponse

interface RatesVolumeService {
    suspend fun getTimesheet(): GetTimesheetResponse
}
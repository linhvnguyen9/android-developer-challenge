package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType
import com.linh.androiddeveloperchallenge.ratesvolume.presentation.model.TimesheetUi

interface UpdateRatesVolumeListener {
    fun onClickRateType(assignmentId: Int, rateType: RateType)
    fun onRateChange(assignmentId: Int, rate: String)
    fun onClickRowSelector(assignmentId: Int, rowId: Int)
    fun onClickApplyToAll(assignmentId: Int)
}

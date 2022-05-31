package com.linh.androiddeveloperchallenge.ratesvolume.presentation.update

import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.RateType

interface UpdateRatesVolumeListener {
    fun onClickRateType(assignmentId: Int, rateType: RateType)
    fun onRateChange(assignmentId: Int, rate: String)
    fun onClickRowSelector(assignmentId: Int, rowId: Int)
    fun onClickApplyToAll(assignmentId: Int)
    fun onRowAssignmentChange(assignmentId: Int, rowId: Int, treesToAssign: Int)
    fun onClickConfirm()
}

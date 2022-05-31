package com.linh.androiddeveloperchallenge.ratesvolume.domain.usecase

import com.linh.androiddeveloperchallenge.ratesvolume.domain.repository.RatesVolumeRepository
import javax.inject.Inject

class GetTimesheetUseCase @Inject constructor(private val repository: RatesVolumeRepository) {
    suspend operator fun invoke() = repository.getTimesheet()
}

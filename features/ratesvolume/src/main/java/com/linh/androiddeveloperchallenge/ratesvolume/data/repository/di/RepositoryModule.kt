package com.linh.androiddeveloperchallenge.ratesvolume.data.repository.di

import com.linh.androiddeveloperchallenge.ratesvolume.data.repository.RatesVolumeRepositoryImpl
import com.linh.androiddeveloperchallenge.ratesvolume.domain.repository.RatesVolumeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindRatesVolumeRepository(impl: RatesVolumeRepositoryImpl): RatesVolumeRepository
}

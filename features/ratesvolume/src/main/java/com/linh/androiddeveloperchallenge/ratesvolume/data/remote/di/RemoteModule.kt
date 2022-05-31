package com.linh.androiddeveloperchallenge.ratesvolume.data.remote.di

import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.RatesVolumeService
import com.linh.androiddeveloperchallenge.ratesvolume.data.remote.RatesVolumeServiceMockImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {
    @Singleton
    @Binds
    fun bindMockRateVolumeService(impl: RatesVolumeServiceMockImpl): RatesVolumeService
}

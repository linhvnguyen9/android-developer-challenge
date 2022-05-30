package com.linh.androiddeveloperchallenge.common.di

import android.content.Context
import com.linh.androiddeveloperchallenge.common.util.ResourceProvider
import com.linh.androiddeveloperchallenge.common.util.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CommonModule {
    @Singleton
    @Binds
    abstract fun bindResourceProvider(impl: ResourceProviderImpl): ResourceProvider
}
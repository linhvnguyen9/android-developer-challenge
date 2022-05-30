package com.linh.androiddeveloperchallenge.common.di

import android.content.Context
import com.linh.androiddeveloperchallenge.common.util.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CommonProvideModule {
    @Singleton
    @Provides
    fun provideResourceProvider(@ApplicationContext context: Context): ResourceProviderImpl {
        return ResourceProviderImpl(context)
    }
}

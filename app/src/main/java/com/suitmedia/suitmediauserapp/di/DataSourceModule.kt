package com.suitmedia.suitmediauserapp.di

import com.suitmedia.suitmediauserapp.data.remote.datasource.UserRemoteDataSource
import com.suitmedia.suitmediauserapp.data.remote.datasource.UserRemoteDataSourceImpl
import com.suitmedia.suitmediauserapp.data.remote.paging.ListUsersPagingSource
import com.suitmedia.suitmediauserapp.data.remote.service.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideUserRemoteDataSource(apiService: UserApiService): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideListUsersPagingSource(dataSource: UserRemoteDataSource): ListUsersPagingSource {
        return ListUsersPagingSource(dataSource)
    }

}
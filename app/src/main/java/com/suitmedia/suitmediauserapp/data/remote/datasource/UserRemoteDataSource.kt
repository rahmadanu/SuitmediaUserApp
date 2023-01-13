package com.suitmedia.suitmediauserapp.data.remote.datasource

import com.suitmedia.suitmediauserapp.data.remote.model.user.ListUsersResponse
import com.suitmedia.suitmediauserapp.data.remote.service.UserApiService
import javax.inject.Inject

interface UserRemoteDataSource {
    suspend fun getListUsers(page: Int): ListUsersResponse
}

class UserRemoteDataSourceImpl @Inject constructor(private val apiService: UserApiService) : UserRemoteDataSource {
    override suspend fun getListUsers(page: Int): ListUsersResponse {
        return apiService.getListUsers(page = page)
    }

}
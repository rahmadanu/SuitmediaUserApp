package com.suitmedia.suitmediauserapp.data.remote.service

import com.suitmedia.suitmediauserapp.data.remote.model.user.ListUsersResponse
import com.suitmedia.suitmediauserapp.util.Constants.DEFAULT_PAGE
import com.suitmedia.suitmediauserapp.util.Constants.SIZE_PER_PAGE
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET(ApiEndPoints.GET_LIST_USERS)
    suspend fun getListUsers(
        @Query("page") page: Int = DEFAULT_PAGE,
        @Query("per_page") sizePerPage: Int = SIZE_PER_PAGE
    ): ListUsersResponse
}
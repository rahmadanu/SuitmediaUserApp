package com.suitmedia.suitmediauserapp.data.remote.service

import retrofit2.http.GET

interface UserApiService {

    @GET(ApiEndPoints.GET_LIST_USERS)
    suspend fun getListUsers()
}
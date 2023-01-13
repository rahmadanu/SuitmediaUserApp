package com.suitmedia.suitmediauserapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.suitmedia.suitmediauserapp.data.remote.model.user.User
import com.suitmedia.suitmediauserapp.data.remote.paging.ListUsersPagingSource
import com.suitmedia.suitmediauserapp.util.Constants.DEFAULT_PAGE

interface UserRepository {
    suspend fun getUserLists(): LiveData<PagingData<User>>
}

class UserRepositoryImpl(private val listUsersPagingSource: ListUsersPagingSource): UserRepository {
    override suspend fun getUserLists(): LiveData<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = DEFAULT_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                listUsersPagingSource
            }
        ).liveData
    }

}
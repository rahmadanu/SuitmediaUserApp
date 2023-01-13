package com.suitmedia.suitmediauserapp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.suitmedia.suitmediauserapp.data.remote.datasource.UserRemoteDataSource
import com.suitmedia.suitmediauserapp.data.remote.model.user.User
import javax.inject.Inject

class ListUsersPagingSource @Inject constructor(
    private val dataSource: UserRemoteDataSource
): PagingSource<Int, User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val pageIndex = params.key ?: 1
        return try {
            val listUsersResponse = dataSource.getListUsers(pageIndex)
            val user = listUsersResponse.data
            LoadResult.Page(
                data = user,
                prevKey = if (pageIndex == 1) null else pageIndex,
                nextKey = if (user.isEmpty()) null else pageIndex + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}
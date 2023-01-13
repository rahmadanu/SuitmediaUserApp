package com.suitmedia.suitmediauserapp.ui.third

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.suitmedia.suitmediauserapp.data.remote.model.user.User
import com.suitmedia.suitmediauserapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooseUserViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    private val _listUsers = MutableLiveData<PagingData<User>>(PagingData.empty())
    val listUsers: LiveData<PagingData<User>> = userRepository.getUserLists().cachedIn(viewModelScope)

    fun getListUsers() {
        viewModelScope.launch {
            val result = userRepository.getUserLists().cachedIn(viewModelScope)
            _listUsers.postValue(result.value)
        }
    }
}
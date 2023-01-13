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
import javax.inject.Inject

@HiltViewModel
class ChooseUserViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    val listUsers: LiveData<PagingData<User>> get() = userRepository.getUserLists().cachedIn(viewModelScope)
}
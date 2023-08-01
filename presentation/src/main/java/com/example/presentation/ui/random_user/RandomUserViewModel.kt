package com.example.presentation.ui.random_user

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.Repository
import com.example.data.di.CoroutineDispatchers
import com.example.domain.entities.remote.RandomUserResponse
import com.example.domain.state.Result
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RandomUserViewModel @Inject constructor(
    private val repository: Repository,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private val _userResponse = MutableLiveData<Result<RandomUserResponse>>()
    val userResponse: LiveData<Result<RandomUserResponse>>
        get() = _userResponse

    @SuppressLint("NullSafeMutableLiveData")
    fun getUsers() {
        viewModelScope.launch {
            safeApiCall(_userResponse, coroutineDispatchers) {
                val response = repository.getRandomUser()
                withContext(Dispatchers.Main) {
                    _userResponse.value = Result.Success(response)
                    _userResponse.value = null
                }
            }
        }
    }

}
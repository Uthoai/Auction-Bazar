package com.top.best.ecommerce.bd.auction.bazar.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.top.best.ecommerce.bd.auction.bazar.core.DataState
import com.top.best.ecommerce.bd.auction.bazar.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthRepository): ViewModel() {
    private val loginResponse = MutableLiveData<DataState<UserLogin>>()
    val loginResponse_: LiveData<DataState<UserLogin>> = loginResponse
    fun userLogin(userLogin: UserLogin){
        loginResponse.postValue(DataState.Loading())
        authService.userLogin(userLogin).addOnSuccessListener {
            loginResponse.postValue(DataState.Success(userLogin))
        }.addOnFailureListener {
            loginResponse.postValue(DataState.Error(it.message))
        }
    }
}
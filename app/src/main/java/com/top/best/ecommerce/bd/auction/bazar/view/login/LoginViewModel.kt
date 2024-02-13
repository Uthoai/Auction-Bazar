package com.top.best.ecommerce.bd.auction.bazar.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.top.best.ecommerce.bd.auction.bazar.core.DataState
import com.top.best.ecommerce.bd.auction.bazar.data.AuthService
import com.top.best.ecommerce.bd.auction.bazar.view.signup.UserSignUp

class LoginViewModel: ViewModel() {
    private val loginResponse = MutableLiveData<DataState<UserLogin>>()
    val loginResponse_: LiveData<DataState<UserLogin>> = loginResponse
    fun userLogin(userLogin: UserLogin){
        loginResponse.postValue(DataState.Loading())
        val authService = AuthService()
        authService.userLogin(userLogin).addOnSuccessListener {
            loginResponse.postValue(DataState.Success(userLogin))
        }.addOnFailureListener {
            loginResponse.postValue(DataState.Error(it.message))
        }
    }
}
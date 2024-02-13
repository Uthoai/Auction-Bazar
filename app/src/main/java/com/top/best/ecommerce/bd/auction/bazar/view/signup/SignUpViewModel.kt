package com.top.best.ecommerce.bd.auction.bazar.view.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.top.best.ecommerce.bd.auction.bazar.core.DataState
import com.top.best.ecommerce.bd.auction.bazar.data.AuthService

class SignUpViewModel: ViewModel() {
    private val signupResponse = MutableLiveData<DataState<UserSignUp>>()
    val signupResponse_: LiveData<DataState<UserSignUp>> = signupResponse
    fun userSignup(userSignUp: UserSignUp){
        signupResponse.postValue(DataState.Loading())

        val authService = AuthService()
        authService.userSignup(userSignUp).addOnSuccessListener {
            signupResponse.postValue(DataState.Success(userSignUp))
        }.addOnFailureListener {
            signupResponse.postValue(DataState.Error(it.message))
        }
    }
}

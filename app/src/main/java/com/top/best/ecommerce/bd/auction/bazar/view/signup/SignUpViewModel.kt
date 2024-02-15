package com.top.best.ecommerce.bd.auction.bazar.view.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.top.best.ecommerce.bd.auction.bazar.core.DataState
import com.top.best.ecommerce.bd.auction.bazar.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authService: AuthRepository) : ViewModel() {
    private val signupResponse = MutableLiveData<DataState<UserSignUp>>()
    val signupResponse_: LiveData<DataState<UserSignUp>> = signupResponse
    fun userSignup(userSignUp: UserSignUp) {
        signupResponse.postValue(DataState.Loading())

        authService.userSignup(userSignUp)
            .addOnSuccessListener {
                it.user?.let {
                    userSignUp.userID = it.uid
                    authService.createUser(userSignUp)
                        .addOnSuccessListener {
                            signupResponse.postValue(DataState.Success(userSignUp))
                        }.addOnFailureListener {
                            signupResponse.postValue(DataState.Error(it.message))
                        }
                }
            }.addOnFailureListener {
                signupResponse.postValue(DataState.Error(it.message))
            }
    }
}

package com.top.best.ecommerce.bd.auction.bazar.data

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.top.best.ecommerce.bd.auction.bazar.view.login.UserLogin
import com.top.best.ecommerce.bd.auction.bazar.view.signup.UserSignUp


interface AuthSource{

    fun userSignup(userSignUp: UserSignUp): Task<AuthResult>
    fun userLogin(userLogin: UserLogin)
    fun userPassword(email: String)
}
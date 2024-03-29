package com.top.best.ecommerce.bd.auction.bazar.data

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.top.best.ecommerce.bd.auction.bazar.core.Nodes
import com.top.best.ecommerce.bd.auction.bazar.view.login.UserLogin
import com.top.best.ecommerce.bd.auction.bazar.view.signup.UserSignUp
import javax.inject.Inject

class AuthRepository @Inject constructor(private val mAuth: FirebaseAuth,private val db: FirebaseFirestore): AuthSource {
    override fun userSignup(userSignUp: UserSignUp): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(userSignUp.email,userSignUp.password)
    }
    override fun userLogin(userLogin: UserLogin): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(userLogin.email,userLogin.password)
    }
    override fun userPassword(email: String) {
    }

    override fun createUser(userSignUp: UserSignUp): Task<Void> {
        return db.collection(Nodes.USER).document(userSignUp.userID).set(userSignUp)
    }
}

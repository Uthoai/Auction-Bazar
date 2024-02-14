package com.top.best.ecommerce.bd.auction.bazar.di

import com.google.firebase.auth.FirebaseAuth
import com.top.best.ecommerce.bd.auction.bazar.data.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth{        //auth service
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebase(mAuth: FirebaseAuth): AuthService{      //use ex- view models
        return AuthService(mAuth)
    }

}
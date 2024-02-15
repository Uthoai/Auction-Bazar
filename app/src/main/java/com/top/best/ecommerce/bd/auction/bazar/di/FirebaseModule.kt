package com.top.best.ecommerce.bd.auction.bazar.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.top.best.ecommerce.bd.auction.bazar.data.AuthRepository
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
    fun provideFirebaseFireStoreDB(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }
    @Provides
    @Singleton
    fun provideFirebase(mAuth: FirebaseAuth,db: FirebaseFirestore): AuthRepository {      //use ex- view models
        return AuthRepository(mAuth,db)
    }
}

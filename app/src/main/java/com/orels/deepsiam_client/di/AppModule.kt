package com.orels.deepsiam_client.di

import com.orels.deepsiam_client.data.remote.repository.Repository
import com.orels.deepsiam_client.data.remote.repository.firebase.FirebaseRepostiry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRepository(): Repository = FirebaseRepostiry()
}
package com.example.movie.di

import com.example.movie.data.network.ApiFactory
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApiFactory(): ApiFactory = ApiFactory()
}
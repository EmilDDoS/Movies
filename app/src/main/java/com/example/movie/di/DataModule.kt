package com.example.movie.di

import com.example.movie.data.mapper.MoviesMapper
import com.example.movie.data.network.ApiFactory
import com.example.movie.data.repository.MovieRepositoryImpl
import com.example.movie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRepository(
        apiFactory: ApiFactory,
        moviesMapper: MoviesMapper
    ): MovieRepository = MovieRepositoryImpl(apiFactory, moviesMapper)

    @Provides
    fun provideApiFactory(): ApiFactory = ApiFactory()

    @Provides
    fun provideMoviesMapper(): MoviesMapper = MoviesMapper()
}
package com.example.movie.di

import com.example.movie.data.mapper.MoviesMapper
import com.example.movie.data.network.ApiFactory
import com.example.movie.data.repository.MovieRepositoryImpl
import com.example.movie.domain.interactor.PopularUseCase
import com.example.movie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideUsdCourseRepositoryUseCase(
        movieRepository: MovieRepository
    ): PopularUseCase = PopularUseCase(movieRepository)
}
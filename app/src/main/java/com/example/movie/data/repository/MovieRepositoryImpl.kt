package com.example.movie.data.repository

import com.example.movie.data.entity.PopulateMoviesDto
import com.example.movie.data.network.ApiFactory
import com.example.movie.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override suspend fun getPopularMovies(): PopulateMoviesDto =
        ApiFactory().instance.getPopularApi()
}
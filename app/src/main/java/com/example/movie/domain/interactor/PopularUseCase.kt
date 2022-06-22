package com.example.movie.domain.interactor

import com.example.movie.domain.repository.MovieRepository

class PopularUseCase(private val repository: MovieRepository) {
    suspend fun execute() = repository.getPopularMovies()
}
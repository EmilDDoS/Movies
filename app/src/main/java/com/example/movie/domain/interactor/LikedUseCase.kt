package com.example.movie.domain.interactor

import com.example.movie.domain.repository.MovieRepository

class LikedUseCase(private val repository: MovieRepository) {
    suspend fun execute() = repository.getLikedMovies()
}
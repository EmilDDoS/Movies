package com.example.movie.domain.repository

import com.example.movie.data.entity.PopulateMoviesDto

interface MovieRepository {
    suspend fun getPopularMovies(): PopulateMoviesDto
}
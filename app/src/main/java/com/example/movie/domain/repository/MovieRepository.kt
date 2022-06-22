package com.example.movie.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.movie.data.entity.MovieDto
import com.example.movie.domain.entity.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): LiveData<PagingData<Movie>>
}
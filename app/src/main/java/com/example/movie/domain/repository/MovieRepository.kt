package com.example.movie.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.movie.data.entity.MovieDto

interface MovieRepository {
    suspend fun getPopularMovies(): LiveData<PagingData<MovieDto>>
}
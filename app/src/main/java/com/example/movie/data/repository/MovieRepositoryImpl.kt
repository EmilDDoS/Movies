package com.example.movie.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.example.movie.data.PopulateMoviesPagingSource
import com.example.movie.data.entity.MovieDto
import com.example.movie.data.entity.PopulateMoviesDto
import com.example.movie.data.network.ApiFactory
import com.example.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(private val apiFactory: ApiFactory) : MovieRepository {
    override suspend fun getPopularMovies(): LiveData<PagingData<MovieDto>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 1),
            pagingSourceFactory = {
                PopulateMoviesPagingSource(apiFactory)
            }
        ).liveData
}
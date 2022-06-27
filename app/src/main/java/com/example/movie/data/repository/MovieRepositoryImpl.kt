package com.example.movie.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.example.movie.data.db.LikedMoviesPagingSource
import com.example.movie.data.db.MovieDao
import com.example.movie.data.db.MovieDataBase
import com.example.movie.data.network.PopulateMoviesPagingSource
import com.example.movie.data.mapper.MoviesMapper
import com.example.movie.data.network.ApiFactory
import com.example.movie.domain.entity.Movie
import com.example.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val apiFactory: ApiFactory,
    private val db: MovieDataBase,
    private val mapper: MoviesMapper
) : MovieRepository {

    override suspend fun getPopularMovies(): LiveData<PagingData<Movie>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 1),
            pagingSourceFactory = {
                PopulateMoviesPagingSource(apiFactory, mapper)
            }
        ).liveData

    override suspend fun getLikedMovies(): LiveData<PagingData<Movie>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 1),
            pagingSourceFactory = {
                LikedMoviesPagingSource(db, mapper)
            }
        ).liveData
}
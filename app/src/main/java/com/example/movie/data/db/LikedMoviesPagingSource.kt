package com.example.movie.data.db

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movie.data.mapper.MoviesMapper
import com.example.movie.domain.entity.Movie

class LikedMoviesPagingSource(
    private val db: MovieDataBase,
    private val mapper: MoviesMapper
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage: Int = params.key ?: 1
            val response = db.movieDao().getLikedMovieList(currentPage)

            LoadResult.Page(
                data = response.let { mapper.movieDbModelToMovies(it) },
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
package com.example.movie.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movie.data.entity.MovieDto
import com.example.movie.data.entity.PopulateMoviesDto
import com.example.movie.data.network.ApiFactory
import com.example.movie.data.network.PopularApi

class PopulateMoviesPagingSource(
    private val service: ApiFactory
) : PagingSource<Int, MovieDto>() {

    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        return try {
            val currentPage: Int = params.key ?: 1
            val response = service.instance.getPopularApi(page = currentPage)

            LoadResult.Page(
                data = response.results,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
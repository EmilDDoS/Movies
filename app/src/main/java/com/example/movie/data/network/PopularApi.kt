package com.example.movie.data.network

import com.example.movie.data.entity.PopulateMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularApi {
    @GET("movie/popular")
    suspend fun getPopularApi(
        @Query("api_key") apiKey: String = "26108de985721f2a6b9f2fb9834449d3",
        @Query("language") language: String = "ru-RU",
        @Query("page") page: Int = 1,
    ): PopulateMoviesDto
}
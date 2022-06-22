package com.example.movie.data.entity

data class PopulateMoviesDto(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)
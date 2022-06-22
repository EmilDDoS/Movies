package com.example.movie.data.mapper

import com.example.movie.data.entity.MovieDto
import com.example.movie.data.entity.PopulateMoviesDto
import com.example.movie.domain.entity.Movie

class MoviesMapper {

    fun movieDtoToMovies(dto: PopulateMoviesDto): List<Movie> {
        return dto.results.map {
            Movie(
                title = it.title,
                overview = it.overview,
                poster_path = it.poster_path,
                release_date = it.release_date,
                vote_average = it.vote_average,
                genre_ids = it.genre_ids
            )
        }
    }
}
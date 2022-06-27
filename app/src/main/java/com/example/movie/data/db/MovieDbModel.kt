package com.example.movie.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "movie_items")
data class MovieDbModel(
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    @field:TypeConverters(GenreConverter::class)
    val genre_ids: List<Int>,
    @PrimaryKey
    val id: Int
)

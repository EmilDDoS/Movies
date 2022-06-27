package com.example.movie.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_items LIMIT :currentPage")
    fun getLikedMovieList(currentPage: Int): List<MovieDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLikedMovie(movie: MovieDbModel)

    @Query("DELETE FROM movie_items WHERE id =:movieId")
    fun deleteMovie(movieId: Int)

    @Query("DELETE FROM movie_items")
    fun clearAll()

}
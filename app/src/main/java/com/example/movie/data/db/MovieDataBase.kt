package com.example.movie.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieDbModel::class], version = 1, exportSchema = false)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
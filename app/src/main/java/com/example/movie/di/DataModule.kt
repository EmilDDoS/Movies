package com.example.movie.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.movie.data.db.MovieDataBase
import com.example.movie.data.mapper.MoviesMapper
import com.example.movie.data.network.ApiFactory
import com.example.movie.data.repository.MovieRepositoryImpl
import com.example.movie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule() {

    @Provides
    fun provideRepository(
        apiFactory: ApiFactory,
        dataBase: MovieDataBase,
        moviesMapper: MoviesMapper
    ): MovieRepository = MovieRepositoryImpl(apiFactory, dataBase , moviesMapper)

    @Provides
    fun provideApiFactory(): ApiFactory = ApiFactory()

    @Provides
    fun provideMoviesMapper(): MoviesMapper = MoviesMapper()

    @Provides
    fun provideDataBase(
        app: Context
    ): MovieDataBase = Room.databaseBuilder(
        app,
        MovieDataBase::class.java,
        "database.db"
    )
        .createFromAsset("initial_database.db")
        .build()
}
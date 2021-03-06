package com.example.movie.di

import androidx.lifecycle.ViewModel
import com.example.movie.domain.interactor.LikedUseCase
import com.example.movie.domain.interactor.PopularUseCase
import com.example.movie.presentation.screens.liked.LikedMoviesViewModel
import com.example.movie.presentation.screens.populate.PopulateMoviesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @IntoMap
    @ClassKey(PopulateMoviesViewModel::class)
    @Provides
    fun getViewModel(
        popularUseCase: PopularUseCase
    ): ViewModel {
        return PopulateMoviesViewModel(popularUseCase)
    }

    @IntoMap
    @ClassKey(LikedMoviesViewModel::class)
    @Provides
    fun getLikedViewModel(
        likedUseCase: LikedUseCase
    ): ViewModel {
        return LikedMoviesViewModel(likedUseCase)
    }

}
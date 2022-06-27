package com.example.movie.presentation.screens.liked

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movie.domain.entity.Movie
import com.example.movie.domain.interactor.LikedUseCase
import com.example.movie.domain.interactor.PopularUseCase

class LikedMoviesViewModel(
    private val likedUseCase: LikedUseCase
) : ViewModel() {

    private var currentResultLiveData: LiveData<PagingData<Movie>>? = null

    suspend fun likedMoviesLiveData(): LiveData<PagingData<Movie>> {
        val newResultLiveData: LiveData<PagingData<Movie>> =
            likedUseCase.execute().cachedIn(viewModelScope)
        currentResultLiveData = newResultLiveData
        return newResultLiveData
    }
}
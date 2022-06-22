package com.example.movie.presentation.screens.populate

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movie.data.entity.MovieDto
import com.example.movie.domain.entity.Movie
import com.example.movie.domain.interactor.PopularUseCase

class PopulateMoviesViewModel(
    private val popularUseCase: PopularUseCase
) : ViewModel() {

    private var currentResultLiveData: LiveData<PagingData<Movie>>? = null

    suspend fun popularMoviesLiveData(): LiveData<PagingData<Movie>> {
        val newResultLiveData: LiveData<PagingData<Movie>> =
            popularUseCase.execute().cachedIn(viewModelScope)
        currentResultLiveData = newResultLiveData
        return newResultLiveData
    }
}
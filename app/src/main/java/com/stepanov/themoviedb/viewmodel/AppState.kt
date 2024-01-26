package com.stepanov.themoviedb.viewmodel

import com.stepanov.themoviedb.domain.Movie

sealed class AppState {
    data object Loading : AppState()
    data class Success(val moviesList: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
}
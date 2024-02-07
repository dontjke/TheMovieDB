package com.stepanov.themoviedb.viewmodel

import com.stepanov.themoviedb.domain.Movie

sealed class MovieDetails {
    data object Loading : MovieDetails()
    data class Success(val movie: Movie) : MovieDetails()
    data class Error(val error: Throwable) : MovieDetails()
}
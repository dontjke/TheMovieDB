package com.stepanov.themoviedb.utils

import com.stepanov.themoviedb.domain.Movie
import com.stepanov.themoviedb.repository.DTO.Details
import com.stepanov.themoviedb.repository.DTO.MovieDTO

const val KEY_BUNDLE_MOVIE = "MOVIE"
const val IMAGE_START_URL = "https://image.tmdb.org/t/p/w500"

fun MovieDTO.toMovie(): Movie {
    return Movie(
        this.id,
        this.title,
        this.posterPath,
        this.voteAverage,
        this.overview,
        this.releaseDate
    )
}

fun Details.toMovie (): Movie{
    return Movie(
        this.id,
        this.title,
        this.posterPath,
        this.voteAverage,
        this.overview,
        this.releaseDate
    )
}

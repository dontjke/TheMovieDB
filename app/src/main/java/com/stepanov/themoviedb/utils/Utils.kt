package com.stepanov.themoviedb.utils

import com.stepanov.themoviedb.domain.Movie
import com.stepanov.themoviedb.repository.dto.DetailsDTO
import com.stepanov.themoviedb.repository.dto.MovieDTO

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

fun DetailsDTO.toMovie (): Movie{
    return Movie(
        this.id,
        this.title,
        this.posterPath,
        this.voteAverage,
        this.overview,
        this.releaseDate
    )
}

package com.stepanov.themoviedb.utils

import com.stepanov.themoviedb.domain.Movie
import com.stepanov.themoviedb.repository.MovieDTO


fun MovieDTO.toMovie(): Movie {
    return Movie(this.title, this.posterPath, this.voteAverage, this.releaseDate)
}
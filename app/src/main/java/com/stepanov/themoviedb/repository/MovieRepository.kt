package com.stepanov.themoviedb.repository

import com.stepanov.themoviedb.domain.Movie

interface MovieRepository {
    fun getMovies(): List<Movie>
    fun getMovieById(id: Int): Movie
}
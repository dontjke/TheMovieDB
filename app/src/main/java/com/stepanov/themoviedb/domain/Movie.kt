package com.stepanov.themoviedb.domain

data class Movie(
    val title: String,
    val posterUrl: String,
    val rating: Double,
    val releaseDate: String
)
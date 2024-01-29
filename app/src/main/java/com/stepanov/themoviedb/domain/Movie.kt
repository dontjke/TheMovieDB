package com.stepanov.themoviedb.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val posterUrl: String,
    val rating: Double,
    val overview: String,
    val releaseDate: String
) : Parcelable
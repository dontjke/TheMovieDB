package com.stepanov.themoviedb.view.adapter

import com.stepanov.themoviedb.domain.Movie

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
}
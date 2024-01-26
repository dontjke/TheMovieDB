package com.stepanov.themoviedb.view.adapter

interface ImageLoader<T> {
    fun loadInto(url: String, container: T)
}
package com.stepanov.themoviedb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stepanov.themoviedb.repository.DefaultMovieRepository
import com.stepanov.themoviedb.repository.MovieRepository


class MoviesViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val defaultMovieRepository: MovieRepository = DefaultMovieRepository()
) : ViewModel() {

    fun getData(): LiveData<AppState> {
        return liveData
    }

    fun getMovie() {
        Thread {
            liveData.postValue(AppState.Loading)
            try {
                val answer = defaultMovieRepository.getMovies()
                liveData.postValue(AppState.Success(answer))
            } catch (e: Exception) {
                liveData.postValue(AppState.Error(IllegalAccessException()))
            }
        }.start()

    }
}
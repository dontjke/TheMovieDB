package com.stepanov.themoviedb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stepanov.themoviedb.repository.DefaultMovieRepository
import com.stepanov.themoviedb.repository.MovieRepository

class MovieDetailsViewModel(
    private val liveData: MutableLiveData<MovieDetails> = MutableLiveData(),
    private val defaultMovieRepository: MovieRepository = DefaultMovieRepository()
) : ViewModel() {

    fun getData(): LiveData<MovieDetails> {
        return liveData
    }

    fun getMovie(id: Int){
        Thread {
            liveData.postValue(MovieDetails.Loading)
            val answer = defaultMovieRepository.getMovieById(id)
            liveData.postValue(MovieDetails.Success(answer))
        }.start()
    }

}
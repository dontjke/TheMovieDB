package com.stepanov.themoviedb.repository

import org.junit.Assert.assertEquals
import org.junit.Test

class FakeMovieRepositoryTest {

    @Test
    fun getMovies() {
        val repository = FakeMovieRepository()
        val fakeMovies = repository.getFakeMovies()
        assertEquals(fakeMovies, null)
    }


}
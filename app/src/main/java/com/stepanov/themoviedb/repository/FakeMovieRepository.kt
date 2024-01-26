package com.stepanov.themoviedb.repository

import com.stepanov.themoviedb.domain.Movie

class FakeMovieRepository : MovieRepository {
    override fun getMovies(): List<Movie> {
        return arrayListOf()
    }

    fun getFakeMovies(): List<Movie> {
        return listOf(
            Movie(
                title = "Wonka",
                posterUrl = "/qhb1qOilapbapxWQn9jtRCMwXJF.jpg",
                rating = 7.2,
                releaseDate = "1703019600000"
            ),
            Movie(
                title = "The Marvels",
                posterUrl = "/9GBhzXMFjgcZ3FdR9w3bUMMTps5.jpg",
                rating = 6.4,
                releaseDate = "1703019600000"
            ),
            /*Movie(
                title = "Aquaman and the Lost Kingdom",
                posterUrl = "/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg",
                rating = 6.7,
                releaseDate = Date(1703019600000)
            ),*/
            Movie(
                title = "Aquaman and the Lost Kingdom",
                posterUrl = "/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg",
                rating = 6.7,
                releaseDate = "1703019600000"
            ),
            Movie(
                title = "Aquaman and the Lost Kingdom",
                posterUrl = "/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg",
                rating = 6.7,
                releaseDate = "1703019600000"
            ),
            Movie(
                title = "Aquaman and the Lost Kingdom",
                posterUrl = "/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg",
                rating = 6.7,
                releaseDate = "1703019600000"
            ),
            Movie(
                title = "Aquaman and the Lost Kingdom",
                posterUrl = "/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg",
                rating = 6.7,
                releaseDate = "1703019600000"
            )
        )
    }
}
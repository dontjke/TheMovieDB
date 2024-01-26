package com.stepanov.themoviedb.repository

import com.google.gson.Gson
import com.stepanov.themoviedb.domain.Movie
import com.stepanov.themoviedb.utils.toMovie
import okhttp3.OkHttpClient
import okhttp3.Request

class DefaultMovieRepository : MovieRepository {
    override fun getMovies(): List<Movie> {

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
            .get()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YzliM2VkMjA3OGYzMzE4NTUwM2ZiNzYxZDExMzczNSIsInN1YiI6IjY1YjI3ZWY0MWM2MzI5MDE2YjkzOTNkZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.LR_RiEqE1CrQIn4R-9XiW5LhM1k9kZUjRk_jB56TSp8"
            )
            .build()


        val response = client.newCall(request).execute()

        val serverResponse = response.body?.string()
        val dto: DTO = Gson().fromJson(serverResponse, DTO::class.java)

        val moviesListDTO = dto.results
        val moviesList = moviesListDTO.map {
            it.toMovie()
        }





        return moviesList
    }


}


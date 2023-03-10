package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.model.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>

}
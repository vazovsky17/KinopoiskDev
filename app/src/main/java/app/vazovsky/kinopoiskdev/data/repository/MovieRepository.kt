package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.model.Movie

interface MovieRepository {

    suspend fun getMovies(genresName: List<String>, name: List<String>, limit: Int): List<Movie>

    suspend fun getMovieById(id: String): Movie

}
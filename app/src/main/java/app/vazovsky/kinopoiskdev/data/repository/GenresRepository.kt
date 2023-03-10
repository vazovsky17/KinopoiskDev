package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.model.GenreFilter

interface GenresRepository {

    suspend fun getGenres(): List<GenreFilter>

}
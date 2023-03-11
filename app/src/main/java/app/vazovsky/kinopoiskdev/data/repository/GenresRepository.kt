package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.model.Genre

interface GenresRepository {

    suspend fun getGenres(): List<Genre>

}
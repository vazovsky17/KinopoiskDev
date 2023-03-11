package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.model.Genre

interface GenresRepository {

    /** Получение жанров */
    suspend fun getGenres(): List<Genre>

}
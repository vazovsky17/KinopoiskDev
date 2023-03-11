package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.model.Movie

interface MovieRepository {

    /**
     * Получение списка фильмов
     *
     * @param genresName жанр
     * @param name название
     * @param limit лимит количества отображаемых фильмов
     */
    suspend fun getMovies(genresName: List<String>, name: List<String>, limit: Int): List<Movie>

    /**
     * Получение фильма по ID
     *
     * @param id ID фильма
     */
    suspend fun getMovieById(id: String): Movie

}
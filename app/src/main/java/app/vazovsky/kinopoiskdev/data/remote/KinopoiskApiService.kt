package app.vazovsky.kinopoiskdev.data.remote

import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.data.remote.model.ApiMovie
import app.vazovsky.kinopoiskdev.data.remote.response.ApiMoviesData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/** Интерфейс для API */
interface KinopoiskApiService {

    /**
     * Получение возможных переменных для фильтрации (используется для получения жанров)
     * @param field тип переменной
     */
    @GET("v1/movie/possible-values-by-field")
    suspend fun getPossibleValuesByField(
        @Query("field") field: String,
    ): List<ApiGenre>

    /**
     * Получение списка фильмов
     *
     * @param genresName жанр
     * @param name название
     * @param limit лимит количества отображаемых фильмов
     */
    @GET("v1/movie")
    suspend fun getMovies(
        @Query("genres.name") genresName: List<String> = emptyList(),
        @Query("name") name: List<String>,
        @Query("limit") limit: Int,
    ): ApiMoviesData

    /**
     * Получение фильма по ID
     *
     * @param id ID фильма
     */
    @GET("v1/movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: String,
    ): ApiMovie

}
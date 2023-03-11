package app.vazovsky.kinopoiskdev.data.remote

import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.data.remote.model.ApiMovie
import app.vazovsky.kinopoiskdev.data.remote.response.ApiMoviesData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApiService {

    @GET("v1/movie/possible-values-by-field")
    suspend fun getPossibleValuesByField(
        @Query("field") field: String,
    ): List<ApiGenre>

    @GET("v1/movie")
    suspend fun getMovies(
        @Query("genres.name") genresName: List<String> = emptyList(),
    ): ApiMoviesData

    @GET("v1/movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: String,
    ): ApiMovie

}
package app.vazovsky.kinopoiskdev.data.remote

import retrofit2.http.GET

interface KinopoiskApiService {

    @GET("v1/movie")
    suspend fun getMovies()

    @GET("v1/movie/{id}")
    suspend fun getMovieById()

}
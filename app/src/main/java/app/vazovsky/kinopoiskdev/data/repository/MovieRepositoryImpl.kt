package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.mapper.MovieMapper
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.remote.KinopoiskApiService
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: KinopoiskApiService,
    private val movieMapper: MovieMapper,
) : MovieRepository {
    override suspend fun getMovies(genresName: List<String>): List<Movie> {
        return apiService.getMovies(genresName).docs.map { movieMapper.fromApiToModel(it) }
    }

    override suspend fun getMovieById(id: String): Movie {
        return movieMapper.fromApiToModel(apiService.getMovieById(id))
    }

}
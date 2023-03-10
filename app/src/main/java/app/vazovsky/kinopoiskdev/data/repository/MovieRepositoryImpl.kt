package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.mapper.MovieMapper
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.remote.KinopoiskApiService
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: KinopoiskApiService,
    private val movieMapper: MovieMapper,
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return apiService.getMovies().docs.map { movieMapper.fromApiToModel(it) }
    }

}
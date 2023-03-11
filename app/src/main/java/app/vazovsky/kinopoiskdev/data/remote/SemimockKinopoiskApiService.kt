package app.vazovsky.kinopoiskdev.data.remote

import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.data.remote.model.ApiMovie
import app.vazovsky.kinopoiskdev.data.remote.response.ApiMoviesData

/** Сервис для выбора, показывать реальные данные с API или моки */
class SemimockKinopoiskApiService(
    private val apiService: KinopoiskApiService,
    private val mockApiService: MockKinopoiskApiService,
) : KinopoiskApiService {

    override suspend fun getPossibleValuesByField(field: String): List<ApiGenre> {
        return apiService.getPossibleValuesByField(field)
    }

    override suspend fun getMovies(genresName: List<String>, name: List<String>, limit: Int): ApiMoviesData {
        return apiService.getMovies(genresName, name, limit)
    }

    override suspend fun getMovieById(id: String): ApiMovie {
        return apiService.getMovieById(id)
    }

}
package app.vazovsky.kinopoiskdev.data.remote

import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.data.remote.response.ApiMoviesData

/** Сервис для выбора, показывать для метода реальные данные с апи или примеры */
class SemimockKinopoiskApiService(
    private val apiService: KinopoiskApiService,
    private val mockApiService: MockKinopoiskApiService,
) : KinopoiskApiService {

    override suspend fun getPossibleValuesByField(field: String): List<ApiGenre> {
        return mockApiService.getPossibleValuesByField(field)
    }

    override suspend fun getMovies(): ApiMoviesData {
        return mockApiService.getMovies()
    }

    override suspend fun getMovieById(id: String) {
        return mockApiService.getMovieById(id)
    }

}
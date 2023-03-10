package app.vazovsky.kinopoiskdev.data.remote

/** Сервис для выбора, показывать для метода реальные данные с апи или примеры */
class SemimockKinopoiskApiService(
    private val apiService: KinopoiskApiService,
    private val mockApiService: MockKinopoiskApiService,
) : KinopoiskApiService {

    override suspend fun getMovies() {
        return mockApiService.getMovies()
    }

    override suspend fun getMovieById() {
        return mockApiService.getMovieById()
    }

}
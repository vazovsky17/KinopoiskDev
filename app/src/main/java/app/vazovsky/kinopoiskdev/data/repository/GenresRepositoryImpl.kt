package app.vazovsky.kinopoiskdev.data.repository

import app.vazovsky.kinopoiskdev.data.mapper.GenreMapper
import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.data.remote.KinopoiskApiService
import javax.inject.Inject

private const val GENRES_NAME = "genres.name"

class GenresRepositoryImpl @Inject constructor(
    private val apiService: KinopoiskApiService,
    private val genreMapper: GenreMapper,
) : GenresRepository {

    override suspend fun getGenres(): List<GenreFilter> {
        return apiService.getPossibleValuesByField(GENRES_NAME).map { genreMapper.fromApiToModel(it) }
    }

}
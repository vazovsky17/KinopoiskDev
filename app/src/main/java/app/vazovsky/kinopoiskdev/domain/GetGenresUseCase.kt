package app.vazovsky.kinopoiskdev.domain

import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.data.repository.GenresRepository
import app.vazovsky.kinopoiskdev.domain.base.UseCase
import app.vazovsky.kinopoiskdev.domain.base.UseCaseUnary
import javax.inject.Inject

/** Получение списка жанров */
class GetGenresUseCase @Inject constructor(
    private val genresRepository: GenresRepository,
) : UseCaseUnary<UseCase.None, List<Genre>>() {

    override suspend fun execute(params: UseCase.None): List<Genre> {
        return genresRepository.getGenres()
    }

}
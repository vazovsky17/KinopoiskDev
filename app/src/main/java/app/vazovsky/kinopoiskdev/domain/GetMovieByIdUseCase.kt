package app.vazovsky.kinopoiskdev.domain

import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.repository.MovieRepository
import app.vazovsky.kinopoiskdev.domain.base.UseCaseUnary
import javax.inject.Inject

/** Получение данных о фильме по ID */
class GetMovieByIdUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : UseCaseUnary<GetMovieByIdUseCase.Params, Movie>() {

    override suspend fun execute(params: Params): Movie {
        return movieRepository.getMovieById(params.id)
    }

    data class Params(
        /** ID фильма */
        val id: String,
    )

}
package app.vazovsky.kinopoiskdev.domain

import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.repository.MovieRepository
import app.vazovsky.kinopoiskdev.domain.base.UseCaseUnary
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : UseCaseUnary<GetMoviesUseCase.Params, List<Movie>>() {

    override suspend fun execute(params: Params): List<Movie> {
        return movieRepository.getMovies(params.genres)
    }

    data class Params(
        /** Список жанров */
        val genres: List<String>,
    )

}
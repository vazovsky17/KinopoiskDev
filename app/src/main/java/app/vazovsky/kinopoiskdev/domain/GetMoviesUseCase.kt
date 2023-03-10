package app.vazovsky.kinopoiskdev.domain

import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.repository.MovieRepository
import app.vazovsky.kinopoiskdev.domain.base.UseCase
import app.vazovsky.kinopoiskdev.domain.base.UseCaseUnary
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : UseCaseUnary<UseCase.None, List<Movie>>() {

    override suspend fun execute(params: UseCase.None): List<Movie> {
        return movieRepository.getMovies()
    }

}
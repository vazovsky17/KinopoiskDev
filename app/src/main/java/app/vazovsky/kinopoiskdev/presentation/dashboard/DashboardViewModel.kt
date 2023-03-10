package app.vazovsky.kinopoiskdev.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.model.base.LoadableResult
import app.vazovsky.kinopoiskdev.domain.GetGenresUseCase
import app.vazovsky.kinopoiskdev.domain.GetMoviesUseCase
import app.vazovsky.kinopoiskdev.domain.base.UseCase
import app.vazovsky.kinopoiskdev.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val destinations: DashboardDestinations,
    private val getGenresUseCase: GetGenresUseCase,
    private val getMoviesUseCase: GetMoviesUseCase,
) : BaseViewModel() {

    /** Доступные жанры */
    private val _genresLiveData = MutableLiveData<LoadableResult<List<GenreFilter>>>()
    val genresLiveData: LiveData<LoadableResult<List<GenreFilter>>> = _genresLiveData

    /** Фильмы */
    private val _moviesLiveData = MutableLiveData<LoadableResult<List<Movie>>>()
    val moviesLiveData: LiveData<LoadableResult<List<Movie>>> = _moviesLiveData

    /** Получение доступных жанров */
    fun getGenres() {
        _genresLiveData.launchLoadData(
            getGenresUseCase.executeFlow(UseCase.None)
        )
    }

    /** Получение списка фильмов */
    fun getMovies() {
        _moviesLiveData.launchLoadData(
            getMoviesUseCase.executeFlow(UseCase.None)
        )
    }

    fun openMovie() {
        navigate(destinations.movie())
    }

}
package app.vazovsky.kinopoiskdev.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.model.base.LoadableResult
import app.vazovsky.kinopoiskdev.domain.GetGenresUseCase
import app.vazovsky.kinopoiskdev.domain.GetMoviesUseCase
import app.vazovsky.kinopoiskdev.domain.base.UseCase
import app.vazovsky.kinopoiskdev.extensions.also
import app.vazovsky.kinopoiskdev.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val MOVIES_LIMIT = 20

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val destinations: DashboardDestinations,
    private val getGenresUseCase: GetGenresUseCase,
    private val getMoviesUseCase: GetMoviesUseCase,
) : BaseViewModel() {

    /** Доступные жанры */
    private val _genresLiveData = MutableLiveData<LoadableResult<List<Genre>>>()
    val genresLiveData: LiveData<LoadableResult<List<Genre>>> = _genresLiveData.also { result ->
        result.doOnSuccess { genres ->
            _genresFiltersLiveData.postValue(genres.map { genre ->
                GenreFilter(
                    name = genre.name,
                    isSelected = false,
                )
            })
        }
    }

    /** Фильтры */
    private val _genresFiltersLiveData = MutableLiveData<List<GenreFilter>>()
    val genresFiltersLiveData: LiveData<List<GenreFilter>> = _genresFiltersLiveData.also {
        getMovies()
    }

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
    fun getMovies(name: String? = null, limit: Int? = MOVIES_LIMIT) {
        val genres = _genresFiltersLiveData.value?.filter { it.isSelected }.orEmpty().map { it.name }
        _moviesLiveData.launchLoadData(
            getMoviesUseCase.executeFlow(GetMoviesUseCase.Params(genres, name, limit))
        )
    }

    /** Обновление фильтра жанра */
    fun updateGenres(genre: GenreFilter) {
        val newList = _genresFiltersLiveData.value?.map { oldGenre ->
            if (oldGenre.name == genre.name) {
                genre
            } else {
                oldGenre
            }
        }
        newList?.let { _genresFiltersLiveData.postValue(it) }
    }

    /** Переход на детальную информацию о фильме */
    fun openMovie(id: String) {
        navigate(destinations.movie(id))
    }

}
package app.vazovsky.kinopoiskdev.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.model.base.LoadableResult
import app.vazovsky.kinopoiskdev.domain.GetMovieByIdUseCase
import app.vazovsky.kinopoiskdev.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieByIdUseCase: GetMovieByIdUseCase,
) : BaseViewModel() {

    /** Раскрыто ли полностью описание фильма */
    var isDescriptionExpanded = false

    /** Детальная информация о фильме */
    private val _movieLiveData = MutableLiveData<LoadableResult<Movie>>()
    val movieLiveData: LiveData<LoadableResult<Movie>> = _movieLiveData

    /** Получение данных о фильме по ID */
    fun getMovie(id: String) {
        _movieLiveData.launchLoadData(
            getMovieByIdUseCase.executeFlow(GetMovieByIdUseCase.Params(id))
        )
    }

    fun showMovie(url: String) {

    }

}
package app.vazovsky.kinopoiskdev.data.remote.response

import app.vazovsky.kinopoiskdev.data.remote.model.ApiMovie
import com.google.gson.annotations.SerializedName

/** Результат запроса фильмов */
data class ApiMoviesData(
    /** Список фильмов */
    @SerializedName("docs") val docs: List<ApiMovie>,
)
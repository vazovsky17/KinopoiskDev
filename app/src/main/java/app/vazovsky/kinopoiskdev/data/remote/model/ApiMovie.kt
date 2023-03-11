package app.vazovsky.kinopoiskdev.data.remote.model

import app.vazovsky.kinopoiskdev.data.model.MovieLengthDataType
import com.google.gson.annotations.SerializedName

/** Фильм */
data class ApiMovie(
    /** Id фильма с кинопоиска */
    @SerializedName("id") val id: Long?,

    /** Название */
    @SerializedName("name") val name: String?,

    /** Описание */
    @SerializedName("description") val description: String?,

    /** Год премьеры */
    @SerializedName("year") val year: Int?,

    /** Рейтинг */
    @SerializedName("rating") val rating: ApiRating?,

    /** Продолжительность фильма */
    @SerializedName("movieLength") val movieLength: MovieLengthDataType?,

    /** Постер */
    @SerializedName("poster") val poster: ApiPoster?,

    /** Похожие фильмы */
    @SerializedName("similarMovies") val similarMovies: List<ApiSimilarMovie>,

    /** Трейлеры, тизеры */
    @SerializedName("videos") val videos: ApiVideos,

    /** Жанры */
    @SerializedName("genres") val genres: List<ApiGenre>,
)
package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Фильм */
data class ApiMovie(
    /** Id фильма с кинопоиска */
    @SerializedName("id") val id: Long?,

    /** Тип тайтла */
    @SerializedName("type") val type: String?,

    /** Название */
    @SerializedName("name") val name: String?,

    /** Описание */
    @SerializedName("description") val description: String?,

    /** Год премьеры */
    @SerializedName("year") val year: Int?,

    /** Рейтинг */
    @SerializedName("rating") val rating: ApiRating?,

    /** Продолжительность фильма */
    @SerializedName("movieLength") val movieLength: Int?,

    /** Постер */
    @SerializedName("poster") val poster: ApiPoster?,

    /** Логотип */
    @SerializedName("logo") val logo: ApiLogo?,
)
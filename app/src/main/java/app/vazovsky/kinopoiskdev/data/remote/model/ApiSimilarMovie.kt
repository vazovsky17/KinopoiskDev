package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Похожий фильм */
data class ApiSimilarMovie(
    /** ID фильма */
    @SerializedName("id") val id: Long?,

    /** Название */
    @SerializedName("name") val name: String?,

    /** Тип тайтла */
    @SerializedName("type") val type: String?,

    /** Постеры */
    @SerializedName("poster") val poster: ApiPoster?,
)
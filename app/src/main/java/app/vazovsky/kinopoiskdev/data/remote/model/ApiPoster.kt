package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Постер фильма */
data class ApiPoster(
    /** Основной постер */
    @SerializedName("url") val url: String?,

    /** Постер для превью */
    @SerializedName("previewUrl") val previewUrl: String?,
)
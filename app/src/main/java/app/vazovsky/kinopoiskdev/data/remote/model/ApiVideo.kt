package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Видео */
data class ApiVideo(
    /** Url трейлера */
    @SerializedName("url") val url: String?,

    /** Название */
    @SerializedName("name") val name: String?,

    /** Сайт с трейлером */
    @SerializedName("site") val site: String?,

    /** Тип видео */
    @SerializedName("type") val type: String?,

    /** Размер */
    @SerializedName("size") val size: Int?,
)
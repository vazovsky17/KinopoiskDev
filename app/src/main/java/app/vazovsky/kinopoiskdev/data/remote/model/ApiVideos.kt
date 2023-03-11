package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Трейлеры, тизеры для фильма */
data class ApiVideos(
    /** Трейлеры */
    @SerializedName("trailers") val trailers: List<ApiVideo>,

    /** Тизеры */
    @SerializedName("teasers") val teasers: List<ApiVideo>,
)
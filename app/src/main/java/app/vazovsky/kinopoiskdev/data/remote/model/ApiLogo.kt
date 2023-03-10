package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Логотип фильма */
data class ApiLogo(
    /** URL логотипа */
    @SerializedName("url") val url: String?,
)
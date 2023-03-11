package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Возможное значение поля фильтрации */
data class ApiGenre(
    /** Значение по которому нужно делать запрос в базу данных */
    @SerializedName("name") val name: String?,

    /** Вспомогательное значение */
    @SerializedName("slug") val slug: String? = null,
)
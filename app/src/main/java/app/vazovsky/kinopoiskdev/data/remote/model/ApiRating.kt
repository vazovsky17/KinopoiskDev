package app.vazovsky.kinopoiskdev.data.remote.model

import com.google.gson.annotations.SerializedName

/** Рейтинг фильма */
data class ApiRating(
    /** Рейтинг кинопоиска */
    @SerializedName("kp") val kp: Double?,

    /** Рейтинг кинокритиков из РФ */
    @SerializedName("russianFilmCritics") val russianFilmCritics: Double?,

    /** Рейтинг кинокритиков */
    @SerializedName("filmCritics") val filmCritics: Double?,
)
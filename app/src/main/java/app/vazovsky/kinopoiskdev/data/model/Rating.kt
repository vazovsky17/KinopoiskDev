package app.vazovsky.kinopoiskdev.data.model

/** Рейтинг фильма */
data class Rating(
    /** Рейтинг кинопоиска */
    val kp: Double,

    /** Рейтинг кинокритиков из РФ */
    val russianFilmCritics: Double,

    /** Рейтинг кинокритиков */
    val filmCritics: Double,
)
package app.vazovsky.kinopoiskdev.data.model

/** Жанр */
data class Genre(
    /** Название */
    val name: String,

    /** Вспомогательное значение */
    val slug: String? = null,
)
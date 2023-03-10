package app.vazovsky.kinopoiskdev.data.model

/** Постер фильма */
data class Poster(
    /** Основной постер */
    val url: String,

    /** Постер для превью */
    val previewUrl: String,
)
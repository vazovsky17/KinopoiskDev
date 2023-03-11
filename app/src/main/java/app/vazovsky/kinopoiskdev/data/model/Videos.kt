package app.vazovsky.kinopoiskdev.data.model


/** Трейлеры, тизеры для фильма */
data class Videos(
    /** Трейлеры */
    val trailers: List<Video>,

    /** Тизеры */
    val teasers: List<Video>,
)
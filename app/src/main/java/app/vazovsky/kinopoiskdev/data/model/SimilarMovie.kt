package app.vazovsky.kinopoiskdev.data.model

/** Похожий фильм */
data class SimilarMovie(
    /** ID фильма */
    val id: Long,

    /** Название */
    val name: String,

    /** Тип тайтла */
    val type: String,

    /** Постеры */
    val poster: Poster,
)
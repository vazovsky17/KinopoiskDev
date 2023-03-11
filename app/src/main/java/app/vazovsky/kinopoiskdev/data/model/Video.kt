package app.vazovsky.kinopoiskdev.data.model

/** Видео */
data class Video(
    /** Url трейлера */
    val url: String,

    /** Название */
    val name: String,

    /** Сайт с трейлером */
    val site: String,

    /** Тип видео */
    val type: String,

    /** Размер */
    val size: Int,
)
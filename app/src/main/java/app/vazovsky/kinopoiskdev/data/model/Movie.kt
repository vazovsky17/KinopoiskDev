package app.vazovsky.kinopoiskdev.data.model

/** Фильм */
data class Movie(
    /** Id фильма с кинопоиска */
    val id: Long,

    /** Тип тайтла */
    val type: String,

    /** Название */
    val name: String,

    /** Описание */
    val description: String,

    /** Год премьеры */
    val year: Int,

    /** Рейтинг */
    val rating: Rating,

    /** Продолжительность фильма */
    val movieLength: Int,

    /** Постер */
    val poster: Poster,

    /** Логотип */
    val logo: Logo,
)
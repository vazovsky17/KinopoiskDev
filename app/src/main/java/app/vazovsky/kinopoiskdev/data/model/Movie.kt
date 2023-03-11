package app.vazovsky.kinopoiskdev.data.model

/** Фильм */
data class Movie(
    /** Id фильма с кинопоиска */
    val id: Long,

    /** Название */
    val name: String,

    /** Описание */
    val description: String,

    /** Год премьеры */
    val year: Int,

    /** Рейтинг */
    val rating: Rating,

    /** Продолжительность фильма */
    val movieLength: MovieLengthDataType,

    /** Постер */
    val poster: Poster,

    /** Похожие фильмы */
    val similarMovies: List<SimilarMovie>,

    /** Трейлеры, тизеры */
    val videos: Videos,

    /** Жанры */
    val genres: List<Genre>,
)
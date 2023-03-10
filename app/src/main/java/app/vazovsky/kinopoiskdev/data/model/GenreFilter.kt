package app.vazovsky.kinopoiskdev.data.model

/** Жанр для фильтрации */
data class GenreFilter(
    /** Название */
    val name: String,

    /** Выбран ли */
    val isSelected: Boolean = false,
)
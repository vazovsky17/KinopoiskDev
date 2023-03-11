package app.vazovsky.kinopoiskdev.managers

import android.content.Context
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.data.model.MovieLengthDataType
import app.vazovsky.kinopoiskdev.extensions.formatDecimal
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/** Форматтер для локальных типов данных */
class DataTypeFormatter @Inject constructor(
    @ApplicationContext val context: Context,
) {
    /**
     * Форматирует продолжительность фильма в минуты и часы
     * Example: 125 -> 2 ч 5 мин
     *
     * @param length продолжительность фильма, в мин
     */
    fun formatMovieLength(length: MovieLengthDataType) = buildString {
        val hours = length / 60
        val minutes = length % 60

        when {
            hours == 0 -> {
                append(minutes)
                append(" ")
                append(context.getString(R.string.movie_movie_length_minutes))
            }

            minutes == 0 -> {
                append(hours.formatDecimal())
                append(" ")
                append(context.getString(R.string.movie_movie_length_hours))
            }

            else -> {
                append(hours.formatDecimal())
                append(" ")
                append(context.getString(R.string.movie_movie_length_hours))
                append(" ")
                append(minutes)
                append(" ")
                append(context.resources.getString(R.string.movie_movie_length_minutes))
            }
        }
    }
}
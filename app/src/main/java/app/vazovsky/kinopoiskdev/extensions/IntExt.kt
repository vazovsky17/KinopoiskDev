package app.vazovsky.kinopoiskdev.extensions

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

/**
 * Форматирвует число в строку с разделением пробелами по три знака
 * Example: 12 000
 */
fun Int.formatDecimal(): String {
    val formatter = NumberFormat.getInstance(Locale("ru", "RU")) as DecimalFormat
    return formatter.format(this)
}

package app.vazovsky.kinopoiskdev.extensions

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

/** Форматирует число в строку с разделенными пробелами по три знака.
 *  14 534
 */
/**
 * Форматирвует число в строку с разделением пробелами по три знака
 * Пример: ""12 000"
 */
fun Int.formatDecimal(): String {
    val formatter = NumberFormat.getInstance(Locale("ru", "RU")) as DecimalFormat
    return formatter.format(this)
}

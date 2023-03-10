package app.vazovsky.kinopoiskdev.presentation.views.recyclerview

/** Интерфейс для ViewHolder с методом, который вызывается при отсоединении view */
interface RecycledViewHolder {
    fun onRecycled()
}
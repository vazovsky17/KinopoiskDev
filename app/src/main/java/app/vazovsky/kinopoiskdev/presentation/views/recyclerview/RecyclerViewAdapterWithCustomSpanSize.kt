package app.vazovsky.kinopoiskdev.presentation.views.recyclerview

/**
 * Определение spanSize для элементов списка
 * Используется в
 * @see GridSpaceItemDecoration
 */
interface RecyclerViewAdapterWithCustomSpanSize {
    fun getSpanSize(position: Int): Int
}
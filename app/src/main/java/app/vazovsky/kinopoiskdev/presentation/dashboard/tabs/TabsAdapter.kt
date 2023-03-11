package app.vazovsky.kinopoiskdev.presentation.dashboard.tabs

import android.view.ViewGroup
import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.BaseAdapter
import javax.inject.Inject

/** Адаптер для отображения табов */
class TabsAdapter @Inject constructor() : BaseAdapter<GenreFilter, TabViewHolder>() {

    lateinit var onItemClick: (GenreFilter, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
        return TabViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateItem(item: GenreFilter, position: Int) {
        items[position] = item
        notifyItemChanged(position)
    }

}
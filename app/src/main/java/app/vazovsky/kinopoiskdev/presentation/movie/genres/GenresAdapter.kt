package app.vazovsky.kinopoiskdev.presentation.movie.genres

import android.view.ViewGroup
import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.BaseAdapter
import javax.inject.Inject

/** Адаптер для отображения жанров */
class GenresAdapter @Inject constructor() : BaseAdapter<Genre, GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(parent)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
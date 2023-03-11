package app.vazovsky.kinopoiskdev.presentation.movie.genres

import android.view.ViewGroup
import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.BaseAdapter
import javax.inject.Inject

class GenresAdapter @Inject constructor() : BaseAdapter<Genre, GenreViewHolder>() {

    lateinit var onItemClick: (Genre) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
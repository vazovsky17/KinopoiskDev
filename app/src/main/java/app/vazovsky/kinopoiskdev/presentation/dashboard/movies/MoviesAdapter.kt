package app.vazovsky.kinopoiskdev.presentation.dashboard.movies

import android.view.ViewGroup
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.BaseAdapter
import javax.inject.Inject

class MoviesAdapter @Inject constructor() : BaseAdapter<Movie, MovieViewHolder>() {

    lateinit var onItemClick: (Movie) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
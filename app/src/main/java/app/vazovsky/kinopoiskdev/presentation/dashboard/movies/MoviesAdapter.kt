package app.vazovsky.kinopoiskdev.presentation.dashboard.movies

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.BaseAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val FADE_DURATION = 1000L

/** Адаптер для отображения фильмов */
class MoviesAdapter @Inject constructor(
    @ApplicationContext val context: Context,
) : BaseAdapter<Movie, MovieViewHolder>() {

    lateinit var onItemClick: (Movie) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
        setFadeAnimation(holder.itemView)
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = FADE_DURATION
        view.startAnimation(anim)
    }
}
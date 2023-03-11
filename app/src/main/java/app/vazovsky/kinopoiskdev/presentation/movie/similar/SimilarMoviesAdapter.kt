package app.vazovsky.kinopoiskdev.presentation.movie.similar

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import app.vazovsky.kinopoiskdev.data.model.SimilarMovie
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.BaseAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val FADE_DURATION = 1000L

/** Адаптер для отображения похожих фильмов */
class SimilarMoviesAdapter @Inject constructor(
    @ApplicationContext val context: Context,
) : BaseAdapter<SimilarMovie, SimilarMovieViewHolder>() {

    lateinit var onItemClick: (SimilarMovie) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMovieViewHolder {
        return SimilarMovieViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: SimilarMovieViewHolder, position: Int) {
        holder.bind(getItem(position))
        setFadeAnimation(holder.itemView)
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = FADE_DURATION
        view.startAnimation(anim)
    }
}
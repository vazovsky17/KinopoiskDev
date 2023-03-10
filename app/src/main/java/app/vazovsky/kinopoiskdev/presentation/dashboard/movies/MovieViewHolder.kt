package app.vazovsky.kinopoiskdev.presentation.dashboard.movies

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.databinding.ItemMovieBinding
import app.vazovsky.kinopoiskdev.extensions.inflate
import app.vazovsky.kinopoiskdev.extensions.load
import by.kirich1409.viewbindingdelegate.viewBinding

class MovieViewHolder(
    parent: ViewGroup,
    private val onItemClick: (Movie) -> Unit,
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_movie)) {
    private val binding by viewBinding(ItemMovieBinding::bind)

    fun bind(item: Movie) = with(binding) {
        textViewName.text = item.name
        imageViewBackground.load(
            imageUrl = item.poster.previewUrl,
        )
        root.setOnClickListener {
            onItemClick(item)
        }
    }
}
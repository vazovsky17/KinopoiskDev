package app.vazovsky.kinopoiskdev.presentation.movie.similar

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.data.model.SimilarMovie
import app.vazovsky.kinopoiskdev.databinding.ItemMovieSquareBinding
import app.vazovsky.kinopoiskdev.extensions.inflate
import app.vazovsky.kinopoiskdev.extensions.load
import by.kirich1409.viewbindingdelegate.viewBinding

class SimilarMovieViewHolder(
    parent: ViewGroup,
    private val onItemClick: (SimilarMovie) -> Unit,
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_movie_square)) {

    private val binding by viewBinding(ItemMovieSquareBinding::bind)

    fun bind(item: SimilarMovie) = with(binding) {
        textViewName.text = item.name
        imageViewBackground.load(
            imageUrl = item.poster.previewUrl,
            placeHolderRes = R.drawable.img_preview,
            errorRes = R.drawable.img_preview,
        )
        root.setOnClickListener {
            onItemClick(item)
        }
    }
}
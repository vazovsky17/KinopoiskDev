package app.vazovsky.kinopoiskdev.presentation.movie.genres

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.databinding.ItemBadgeBinding
import app.vazovsky.kinopoiskdev.extensions.inflate
import by.kirich1409.viewbindingdelegate.viewBinding

class GenreViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_badge)) {
    private val binding by viewBinding(ItemBadgeBinding::bind)

    private val listOfColors = listOf(
        R.color.indian_green,
        R.color.indian_orange,
        R.color.american_red,
        R.color.pride,
        R.color.cadbury_purple,
    )

    fun bind(item: Genre) = with(binding) {
        badgeViewGenre.setBadgeText(item.name)
        badgeViewGenre.setBadgeColor(root.context.getColor(listOfColors[bindingAdapterPosition % 5]))
    }
}
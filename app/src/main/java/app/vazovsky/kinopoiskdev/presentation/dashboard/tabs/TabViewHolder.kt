package app.vazovsky.kinopoiskdev.presentation.dashboard.tabs

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.databinding.ItemFilterTabBinding
import app.vazovsky.kinopoiskdev.extensions.inflate
import by.kirich1409.viewbindingdelegate.viewBinding

class TabViewHolder(
    parent: ViewGroup,
    private val onItemClick: (GenreFilter, Int) -> Unit,
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_filter_tab)) {
    private val binding by viewBinding(ItemFilterTabBinding::bind)

    fun bind(item: GenreFilter) = with(binding.root) {
        text = item.name
        isChecked = item.isSelected
        isCloseIconVisible = isChecked
        setOnClickListener {
            isChecked = item.isSelected
            onItemClick(item, bindingAdapterPosition)
        }
    }
}
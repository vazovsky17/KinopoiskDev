package app.vazovsky.kinopoiskdev.extensions

import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.GridSpaceItemDecoration

fun RecyclerView.addDefaultGridSpaceItemDecoration(
    spanCount: Int,
    @DimenRes spacing: Int = R.dimen.padding_8,
    includeEdge: Boolean = false,
    excludeTopEdge: Boolean = true
) {
    val itemDecoration = GridSpaceItemDecoration(
        spanCount,
        context.resources.getDimensionPixelSize(spacing),
        includeEdge,
        excludeTopEdge
    )
    this.addItemDecoration(itemDecoration)
}
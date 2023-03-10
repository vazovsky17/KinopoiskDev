package app.vazovsky.kinopoiskdev.extensions

import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.kinopoiskdev.R
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.GridSpaceItemDecoration
import app.vazovsky.kinopoiskdev.presentation.views.recyclerview.LinearSpaceItemDecoration

fun RecyclerView.addLinearSpaceItemDecoration(
    @DimenRes spacing: Int = R.dimen.padding_4,
    showFirstVerticalDivider: Boolean = false,
    showLastVerticalDivider: Boolean = false,
    showFirstHorizontalDivider: Boolean = false,
    showLastHorizontalDivider: Boolean = false,
    conditionProvider: LinearSpaceItemDecoration.ConditionProvider? = null,
) {
    this.addItemDecoration(
        LinearSpaceItemDecoration(
            context.resources.getDimensionPixelSize(spacing),
            showFirstVerticalDivider,
            showLastVerticalDivider,
            showFirstHorizontalDivider,
            showLastHorizontalDivider,
            conditionProvider,
        )
    )
}

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
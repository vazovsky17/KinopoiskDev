package app.vazovsky.kinopoiskdev.data.mapper

import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.extensions.orDefault
import javax.inject.Inject

class GenreMapper @Inject constructor() {

    fun fromApiToModel(apiModel: ApiGenre?): GenreFilter {
        return GenreFilter(
            name = apiModel?.name.orDefault(),
            slug = apiModel?.slug.orDefault(),
            isSelected = false,
        )
    }

}
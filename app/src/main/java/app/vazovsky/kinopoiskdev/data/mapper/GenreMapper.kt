package app.vazovsky.kinopoiskdev.data.mapper

import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.data.model.GenreFilter
import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.extensions.orDefault
import javax.inject.Inject

class GenreMapper @Inject constructor() {

    fun fromApiToModel(apiModel: ApiGenre?): Genre {
        return Genre(
            name = apiModel?.name.orDefault(),
            slug = apiModel?.slug.orDefault(),
        )
    }

}
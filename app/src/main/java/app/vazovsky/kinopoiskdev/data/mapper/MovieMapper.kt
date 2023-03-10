package app.vazovsky.kinopoiskdev.data.mapper

import app.vazovsky.kinopoiskdev.data.model.Logo
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.model.Poster
import app.vazovsky.kinopoiskdev.data.model.Rating
import app.vazovsky.kinopoiskdev.data.remote.model.ApiLogo
import app.vazovsky.kinopoiskdev.data.remote.model.ApiMovie
import app.vazovsky.kinopoiskdev.data.remote.model.ApiPoster
import app.vazovsky.kinopoiskdev.data.remote.model.ApiRating
import app.vazovsky.kinopoiskdev.extensions.orDefault
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun fromApiToModel(apiModel: ApiMovie?): Movie {
        return Movie(
            id = apiModel?.id.orDefault(),
            type = apiModel?.type.orDefault(),
            name = apiModel?.name.orDefault(),
            description = apiModel?.description.orDefault(),
            year = apiModel?.year.orDefault(),
            rating = fromApiToModel(apiModel?.rating),
            movieLength = apiModel?.movieLength.orDefault(),
            poster = fromApiToModel(apiModel?.poster),
            logo = fromApiToModel(apiModel?.logo),
        )
    }

    private fun fromApiToModel(apiModel: ApiRating?): Rating {
        return Rating(
            kp = apiModel?.kp.orDefault(),
            russianFilmCritics = apiModel?.russianFilmCritics.orDefault(),
            filmCritics = apiModel?.filmCritics.orDefault(),
        )
    }

    private fun fromApiToModel(apiModel: ApiPoster?): Poster {
        return Poster(
            url = apiModel?.url.orDefault(),
            previewUrl = apiModel?.url.orDefault(),
        )
    }

    private fun fromApiToModel(apiModel: ApiLogo?): Logo {
        return Logo(
            url = apiModel?.url.orDefault(),
        )
    }

}
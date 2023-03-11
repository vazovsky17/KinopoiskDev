package app.vazovsky.kinopoiskdev.data.mapper

import app.vazovsky.kinopoiskdev.data.model.Genre
import app.vazovsky.kinopoiskdev.data.model.Movie
import app.vazovsky.kinopoiskdev.data.model.Poster
import app.vazovsky.kinopoiskdev.data.model.Rating
import app.vazovsky.kinopoiskdev.data.model.SimilarMovie
import app.vazovsky.kinopoiskdev.data.model.Video
import app.vazovsky.kinopoiskdev.data.model.Videos
import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.data.remote.model.ApiMovie
import app.vazovsky.kinopoiskdev.data.remote.model.ApiPoster
import app.vazovsky.kinopoiskdev.data.remote.model.ApiRating
import app.vazovsky.kinopoiskdev.data.remote.model.ApiSimilarMovie
import app.vazovsky.kinopoiskdev.data.remote.model.ApiVideo
import app.vazovsky.kinopoiskdev.data.remote.model.ApiVideos
import app.vazovsky.kinopoiskdev.extensions.orDefault
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun fromApiToModel(apiModel: ApiMovie?): Movie {
        return Movie(
            id = apiModel?.id.orDefault(),
            name = apiModel?.name.orDefault(),
            description = apiModel?.description.orDefault(),
            year = apiModel?.year.orDefault(),
            rating = fromApiToModel(apiModel?.rating),
            movieLength = apiModel?.movieLength.orDefault(),
            poster = fromApiToModel(apiModel?.poster),
            similarMovies = apiModel?.similarMovies.orEmpty().map { fromApiToModel(it) },
            videos = fromApiToModel(apiModel?.videos),
            genres = apiModel?.genres.orEmpty().map { fromApiToModel(it) }
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

    private fun fromApiToModel(apiModel: ApiSimilarMovie?): SimilarMovie {
        return SimilarMovie(
            id = apiModel?.id.orDefault(),
            name = apiModel?.name.orDefault(),
            type = apiModel?.type.orDefault(),
            poster = fromApiToModel(apiModel?.poster),
        )
    }

    private fun fromApiToModel(apiModel: ApiVideos?): Videos {
        return Videos(
            trailers = apiModel?.trailers.orEmpty().map { fromApiToModel(it) },
            teasers = apiModel?.teasers.orEmpty().map { fromApiToModel(it) },
        )
    }

    private fun fromApiToModel(apiModel: ApiVideo?): Video {
        return Video(
            url = apiModel?.url.orDefault(),
            name = apiModel?.name.orDefault(),
            site = apiModel?.site.orDefault(),
            type = apiModel?.type.orDefault(),
            size = apiModel?.size.orDefault(),
        )
    }

    private fun fromApiToModel(apiModel: ApiGenre?): Genre {
        return Genre(
            name = apiModel?.name.orDefault(),
        )
    }

}
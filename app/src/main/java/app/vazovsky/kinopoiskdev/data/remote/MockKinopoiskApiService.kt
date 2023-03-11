package app.vazovsky.kinopoiskdev.data.remote

import app.vazovsky.kinopoiskdev.data.remote.model.ApiGenre
import app.vazovsky.kinopoiskdev.data.remote.model.ApiMovie
import app.vazovsky.kinopoiskdev.data.remote.model.ApiPoster
import app.vazovsky.kinopoiskdev.data.remote.model.ApiRating
import app.vazovsky.kinopoiskdev.data.remote.model.ApiSimilarMovie
import app.vazovsky.kinopoiskdev.data.remote.model.ApiVideos
import app.vazovsky.kinopoiskdev.data.remote.response.ApiMoviesData

class MockKinopoiskApiService : KinopoiskApiService {

    private val genres = listOf(
        ApiGenre(
            name = "аниме",
        ),
        ApiGenre(
            name = "мультфильм",
        ),
        ApiGenre(
            name = "фэнтези",
        ),
        ApiGenre(
            name = "приключения",
        ),
        ApiGenre(
            name = "семейный",
        ),
    )

    private val similarMovies = listOf(
        ApiSimilarMovie(
            id = 49684,
            name = "Ходячий замок",
            type = "anime",
            poster = ApiPoster(
                url = "https://avatars.mds.yandex.net/get-kinopoisk-image/" +
                        "1946459/399bb0c1-2ac5-46ca-9efd-50d8708e2809/orig",
                previewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/" +
                        "399bb0c1-2ac5-46ca-9efd-50d8708e2809/x1000",
            ),
        ),
        ApiSimilarMovie(
            id = 8221,
            name = "Мой сосед Тоторо",
            type = "anime",
            poster = ApiPoster(
                url = "https://avatars.mds.yandex.net/get-kinopoisk-image/1704946" +
                        "/029f472e-bf4d-4e00-b7c0-f45c08cf8b82/orig",
                previewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/" +
                        "029f472e-bf4d-4e00-b7c0-f45c08cf8b82/x1000",
            ),
        ),
    )
    private var movies = listOf(
        ApiMovie(
            id = 370,
            name = "Унесённые призраками",
            description = "Тихиро с мамой и папой переезжает в новый дом. " +
                    "Заблудившись по дороге, они оказываются в странном пустынном городе, " +
                    "где их ждет великолепный пир. Родители с жадностью набрасываются на еду и к ужасу девочки " +
                    "превращаются в свиней, став пленниками злой колдуньи Юбабы. Теперь, оказавшись одна среди " +
                    "волшебных существ и загадочных видений, Тихиро должна придумать, как избавить своих родителей " +
                    "от чар коварной старухи.",
            year = 2001,
            rating = ApiRating(
                kp = 8.478,
                russianFilmCritics = 100.0,
                filmCritics = 8.6,
            ),
            movieLength = 125,
            poster = ApiPoster(
                url = "https://st.kp.yandex.net/images/film_big/370.jpg",
                previewUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_370.jpg",
            ),
            similarMovies = similarMovies,
            videos = ApiVideos(
                trailers = listOf(),
                teasers = listOf()
            ),
            genres = genres,
        ),
        ApiMovie(
            id = 8221,
            name = "Мой сосед Тоторо",
            description = "Сестры Сацуки и Мэй переезжают вместе с папой в деревенский дом. Однажды девочки обнаруживают, " +
                    "что по соседству с ними живут лесные духи — хранители леса во главе со своим могущественным и " +
                    "добрым повелителем Тоторо. Постепенно Тоторо становится другом девочек, помогая " +
                    "им в их повседневных приключениях.",
            year = 1988,
            rating = ApiRating(
                kp = 8.217,
                russianFilmCritics = 0.0,
                filmCritics = 8.4,
            ),
            movieLength = 86,
            poster = ApiPoster(
                url = "https://st.kp.yandex.net/images/film_big/8221.jpg",
                previewUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_8221.jpg",
            ),
            similarMovies = similarMovies,
            videos = ApiVideos(
                trailers = listOf(),
                teasers = listOf()
            ),
            genres = genres,
        ),
        ApiMovie(
            id = 49684,
            name = "Ходячий замок",
            description = "Злая ведьма заточила 18-летнюю Софи в тело старухи. " +
                    "Девушка-бабушка бежит из города куда глаза глядят и встречает удивительный дом " +
                    "на ножках, где знакомится с могущественным волшебником Хаулом и демоном Кальцифером. " +
                    "Кальцифер должен служить Хаулу по договору, условия которого он не может разглашать. " +
                    "Девушка и демон решают помочь друг другу избавиться от злых чар.",
            year = 2004,
            rating = ApiRating(
                kp = 8.317,
                russianFilmCritics = 100.0,
                filmCritics = 7.5,
            ),
            movieLength = 119,
            poster = ApiPoster(
                url = "https://st.kp.yandex.net/images/film_big/49684.jpg",
                previewUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_49684.jpg",
            ),
            similarMovies = similarMovies,
            videos = ApiVideos(
                trailers = listOf(),
                teasers = listOf()
            ),
            genres = genres,
        ),
        ApiMovie(
            id = 749374,
            name = "Атака титанов",
            description = "Уже многие годы человечество ведёт борьбу с титанами — огромными существами, " +
                    "которые не обладают особым интеллектом, зато едят людей и получают от этого удовольствие. " +
                    "После продолжительной борьбы остатки человечества построили высокую стену, окружившую страну людей, " +
                    "через которую титаны пройти не могли. С тех пор прошло сто лет, люди мирно живут под защитой стены. " +
                    "Но однажды подросток Эрэн и его сводная сестра Микаса становятся свидетелями страшного события — " +
                    "участок стены разрушается супертитаном, появившимся прямо из воздуха. Титаны нападают на город, " +
                    "и дети в ужасе видят, как один из монстров заживо съедает их мать. " +
                    "Эрэн клянётся, что убьёт всех титанов и отомстит за человечество.",
            year = 2013,
            rating = ApiRating(
                kp = 8.657,
                russianFilmCritics = 100.0,
                filmCritics = 0.0,
            ),
            movieLength = 24,
            poster = ApiPoster(
                url = "https://st.kp.yandex.net/images/film_big/749374.jpg",
                previewUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_749374.jpg",
            ),
            similarMovies = similarMovies,
            videos = ApiVideos(
                trailers = listOf(),
                teasers = listOf()
            ),
            genres = genres,
        )
    )

    override suspend fun getPossibleValuesByField(field: String): List<ApiGenre> {
        return listOf(
            ApiGenre(
                name = "аниме",
                slug = "anime",
            ),
            ApiGenre(
                name = "биография",
                slug = "biografiya",
            ),
            ApiGenre(
                name = "боевик",
                slug = "boevik",
            ),
            ApiGenre(
                name = "вестерн",
                slug = "vestern",
            ),
            ApiGenre(
                name = "военный",
                slug = "voennyy",
            ),
        )
    }

    override suspend fun getMovies(genresName: List<String>): ApiMoviesData {
        return ApiMoviesData(
            docs = movies,
        )
    }

    override suspend fun getMovieById(id: String): ApiMovie {
        return movies.first { it.id.toString() == id }
    }

}
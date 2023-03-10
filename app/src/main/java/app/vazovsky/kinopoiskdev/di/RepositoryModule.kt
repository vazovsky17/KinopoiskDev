package app.vazovsky.kinopoiskdev.di

import app.vazovsky.kinopoiskdev.data.repository.GenresRepository
import app.vazovsky.kinopoiskdev.data.repository.GenresRepositoryImpl
import app.vazovsky.kinopoiskdev.data.repository.MovieRepository
import app.vazovsky.kinopoiskdev.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/** Модуль для привязки репозиториев */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGenresRepository(
        genresRepository: GenresRepositoryImpl
    ): GenresRepository

    @Binds
    abstract fun bindMovieRepository(
        movieRepository: MovieRepositoryImpl
    ): MovieRepository

}
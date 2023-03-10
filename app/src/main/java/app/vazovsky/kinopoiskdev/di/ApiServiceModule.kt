package app.vazovsky.kinopoiskdev.di

import app.vazovsky.kinopoiskdev.data.remote.KinopoiskApiService
import app.vazovsky.kinopoiskdev.data.remote.MockKinopoiskApiService
import app.vazovsky.kinopoiskdev.data.remote.SemimockKinopoiskApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.kinopoisk.dev/"

/** Модуль подключения к Api */
@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    @Singleton
    @Provides
    fun provideApiService(
        retrofit: Retrofit,
    ): KinopoiskApiService {
        return SemimockKinopoiskApiService(
            apiService = retrofit.create(KinopoiskApiService::class.java),
            mockApiService = MockKinopoiskApiService(),
        )
    }

}

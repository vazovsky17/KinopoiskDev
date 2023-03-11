package app.vazovsky.kinopoiskdev.di

import android.content.Context
import app.vazovsky.kinopoiskdev.data.remote.KinopoiskApiService
import app.vazovsky.kinopoiskdev.data.remote.MockKinopoiskApiService
import app.vazovsky.kinopoiskdev.data.remote.SemimockKinopoiskApiService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.kinopoisk.dev/"
private const val TOKEN = "MW0H6PC-HSE4CRS-H00KVGR-ACS388D"

/** Модуль подключения к Api */
@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Singleton
    @Provides
    fun provideClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().addHeader("X-API-KEY", TOKEN).build()
                )
            }.addInterceptor(ChuckerInterceptor(context)).build()
    }


    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(client).build()
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

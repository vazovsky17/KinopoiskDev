package app.vazovsky.kinopoiskdev.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

//    @Singleton
//    @Provides
//    fun provideRoomDatabases(
//        application: Application,
//    ): AppDatabase {
//        return Room.databaseBuilder(
//            application,
//            AppDatabase::class.java,
//            AppDatabase.DATABASE_NAME,
//        ).build()
//    }

}

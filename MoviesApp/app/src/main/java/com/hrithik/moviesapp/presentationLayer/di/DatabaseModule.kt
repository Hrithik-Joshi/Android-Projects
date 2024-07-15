package com.hrithik.moviesapp.presentationLayer.di

import android.content.Context
import androidx.room.Room
import com.hrithik.moviesapp.dataLayer.db.MovieDao
import com.hrithik.moviesapp.dataLayer.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context,
            TMDBDatabase::class.java,
            "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

}
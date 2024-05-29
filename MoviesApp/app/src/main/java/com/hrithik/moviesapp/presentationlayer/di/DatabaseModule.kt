package com.hrithik.moviesapp.presentationlayer.di

import android.content.Context
import androidx.room.Room
import com.hrithik.moviesapp.datalayer.db.MovieDao
import com.hrithik.moviesapp.datalayer.db.TMDBDatabase
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
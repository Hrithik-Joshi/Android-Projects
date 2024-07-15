package com.hrithik.moviesapp.presentationLayer.di

import com.hrithik.moviesapp.dataLayer.datasource.MovieLocalDataSource
import com.hrithik.moviesapp.dataLayer.datasourceImpl.MovieLocalDataSourceImpl
import com.hrithik.moviesapp.dataLayer.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

}
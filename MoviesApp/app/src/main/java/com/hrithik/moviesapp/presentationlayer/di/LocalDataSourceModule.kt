package com.hrithik.moviesapp.presentationlayer.di

import com.hrithik.moviesapp.datalayer.datasource.MovieLocalDataSource
import com.hrithik.moviesapp.datalayer.datasourceImpl.MovieLocalDataSourceImpl
import com.hrithik.moviesapp.datalayer.db.MovieDao
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
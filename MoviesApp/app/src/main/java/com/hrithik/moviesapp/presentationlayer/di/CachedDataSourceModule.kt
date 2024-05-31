package com.hrithik.moviesapp.presentationlayer.di

import com.hrithik.moviesapp.datalayer.datasource.MovieCachedDataSource
import com.hrithik.moviesapp.datalayer.datasourceImpl.MovieCachedDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CachedDataSourceModule {

    @Singleton
    @Provides
    fun provideCachedDataSource():MovieCachedDataSource{
        return MovieCachedDataSourceImpl()
    }
}
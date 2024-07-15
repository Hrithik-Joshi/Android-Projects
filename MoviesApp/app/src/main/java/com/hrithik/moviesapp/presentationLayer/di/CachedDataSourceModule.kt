package com.hrithik.moviesapp.presentationLayer.di

import com.hrithik.moviesapp.dataLayer.datasource.MovieCachedDataSource
import com.hrithik.moviesapp.dataLayer.datasourceImpl.MovieCachedDataSourceImpl
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
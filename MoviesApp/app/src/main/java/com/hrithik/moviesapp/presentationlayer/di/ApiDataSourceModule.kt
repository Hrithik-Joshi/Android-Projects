package com.hrithik.moviesapp.presentationlayer.di

import com.hrithik.moviesapp.datalayer.datasource.MovieApiDataSource
import com.hrithik.moviesapp.datalayer.datasourceImpl.MovieApiDataSourceImpl
import com.hrithik.moviesapp.datalayer.retrofit.TMDBApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiDataSourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieApiDataSource(tmdbService: TMDBApiService): MovieApiDataSource {
        return MovieApiDataSourceImpl(tmdbService, apiKey)
    }
}
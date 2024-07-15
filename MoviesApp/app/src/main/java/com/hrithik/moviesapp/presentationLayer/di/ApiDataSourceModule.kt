package com.hrithik.moviesapp.presentationLayer.di

import com.hrithik.moviesapp.dataLayer.datasource.MovieApiDataSource
import com.hrithik.moviesapp.dataLayer.datasourceImpl.MovieApiDataSourceImpl
import com.hrithik.moviesapp.dataLayer.retrofit.TMDBApiService
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
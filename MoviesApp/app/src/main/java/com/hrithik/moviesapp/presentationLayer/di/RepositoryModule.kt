package com.hrithik.moviesapp.presentationLayer.di

import com.hrithik.moviesapp.dataLayer.datasource.MovieApiDataSource
import com.hrithik.moviesapp.dataLayer.datasource.MovieCachedDataSource
import com.hrithik.moviesapp.dataLayer.datasource.MovieLocalDataSource
import com.hrithik.moviesapp.domainLayer.repository.MovieRepository
import com.hrithik.moviesapp.domainLayer.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        movieApiDataSource: MovieApiDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCachedDataSource: MovieCachedDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieApiDataSource, movieLocalDataSource, movieCachedDataSource)
    }
}
package com.hrithik.moviesapp.presentationlayer.di

import com.hrithik.moviesapp.datalayer.datasource.MovieApiDataSource
import com.hrithik.moviesapp.datalayer.datasource.MovieCachedDataSource
import com.hrithik.moviesapp.datalayer.datasource.MovieLocalDataSource
import com.hrithik.moviesapp.domainlayer.repository.MovieRepository
import com.hrithik.moviesapp.domainlayer.repository.MovieRepositoryImpl
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
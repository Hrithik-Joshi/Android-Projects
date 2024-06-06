package com.hrithik.moviesapp.presentationlayer.di

import com.hrithik.moviesapp.domainlayer.repository.MovieRepository
import com.hrithik.moviesapp.domainlayer.usecases.GetMoviesUseCase
import com.hrithik.moviesapp.domainlayer.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun providesGetMoviesUseCaseModule(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun providesUpdateMoviesUseCaseModule(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }
}
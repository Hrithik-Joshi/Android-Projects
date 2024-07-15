package com.hrithik.moviesapp.presentationLayer.di

import com.hrithik.moviesapp.domainLayer.repository.MovieRepository
import com.hrithik.moviesapp.domainLayer.usecases.GetMoviesUseCase
import com.hrithik.moviesapp.domainLayer.usecases.UpdateMoviesUseCase
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
package com.hrithik.moviesapp.presentationLayer.di

import com.hrithik.moviesapp.domainLayer.usecases.GetMoviesUseCase
import com.hrithik.moviesapp.domainLayer.usecases.UpdateMoviesUseCase
import com.hrithik.moviesapp.presentationLayer.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @MovieScope
    @Provides
    fun provideViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}
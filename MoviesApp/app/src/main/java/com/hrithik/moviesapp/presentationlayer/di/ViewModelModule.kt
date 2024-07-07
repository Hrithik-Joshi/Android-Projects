package com.hrithik.moviesapp.presentationlayer.di

import com.hrithik.moviesapp.domainlayer.usecases.GetMoviesUseCase
import com.hrithik.moviesapp.domainlayer.usecases.UpdateMoviesUseCase
import com.hrithik.moviesapp.presentationlayer.ViewModelFactory
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
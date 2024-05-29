package com.hrithik.moviesapp.presentationlayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hrithik.moviesapp.domainlayer.usecases.GetMoviesUseCase
import com.hrithik.moviesapp.domainlayer.usecases.UpdateMoviesUseCase

class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.hrithik.moviesapp.presentationlayer.MyViewModel(
            getMoviesUseCase,
            getUpdateMoviesUseCase
        ) as T
    }
}
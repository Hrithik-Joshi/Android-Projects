package com.hrithik.moviesapp.presentationLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hrithik.moviesapp.domainLayer.usecases.GetMoviesUseCase
import com.hrithik.moviesapp.domainLayer.usecases.UpdateMoviesUseCase

class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.hrithik.moviesapp.presentationLayer.MyViewModel(
            getMoviesUseCase,
            getUpdateMoviesUseCase
        ) as T
    }
}
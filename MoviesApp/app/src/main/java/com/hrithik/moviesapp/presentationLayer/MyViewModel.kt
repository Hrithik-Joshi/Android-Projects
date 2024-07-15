package com.hrithik.moviesapp.presentationLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hrithik.moviesapp.domainLayer.usecases.GetMoviesUseCase
import com.hrithik.moviesapp.domainLayer.usecases.UpdateMoviesUseCase

class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val moviesList = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun getUpdatedMovies() = liveData {
        val moviesList = getUpdateMoviesUseCase.execute()
        emit(moviesList)
    }
}
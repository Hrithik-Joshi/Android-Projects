package com.hrithik.moviesapp.domainLayer.repository

import com.hrithik.moviesapp.dataLayer.model.Movie

interface MovieRepository {

    suspend fun getAllMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?

}
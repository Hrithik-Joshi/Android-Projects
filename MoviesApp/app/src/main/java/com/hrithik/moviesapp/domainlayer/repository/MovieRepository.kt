package com.hrithik.moviesapp.domainlayer.repository

import com.hrithik.moviesapp.datalayer.model.Movie

interface MovieRepository {

    suspend fun getAllMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?

}
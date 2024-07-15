package com.hrithik.moviesapp.dataLayer.datasource

import com.hrithik.moviesapp.dataLayer.model.Movie

interface MovieLocalDataSource {

    suspend fun getMovieFromDb() : List<Movie>

    suspend fun saveMovieToDb(movies: List<Movie>)

    suspend fun clearAll()
}
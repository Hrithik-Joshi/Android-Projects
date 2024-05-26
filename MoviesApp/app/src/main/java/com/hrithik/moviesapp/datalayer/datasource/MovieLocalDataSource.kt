package com.hrithik.moviesapp.datalayer.datasource

import com.hrithik.moviesapp.datalayer.model.Movie

interface MovieLocalDataSource {

    suspend fun getMovieFromDb() : List<Movie>

    suspend fun saveMovie(movies: List<Movie>)

    suspend fun clearAll()
}
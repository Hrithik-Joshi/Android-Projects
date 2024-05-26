package com.hrithik.moviesapp.datalayer.datasource

import com.hrithik.moviesapp.datalayer.model.Movie

interface MovieCachedDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}
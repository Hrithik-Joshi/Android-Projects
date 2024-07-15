package com.hrithik.moviesapp.dataLayer.datasource

import com.hrithik.moviesapp.dataLayer.model.Movie

interface MovieCachedDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}
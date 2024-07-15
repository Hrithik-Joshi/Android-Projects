package com.hrithik.moviesapp.dataLayer.datasourceImpl

import com.hrithik.moviesapp.dataLayer.datasource.MovieCachedDataSource
import com.hrithik.moviesapp.dataLayer.model.Movie

class MovieCachedDataSourceImpl : MovieCachedDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movieList)
    }
}
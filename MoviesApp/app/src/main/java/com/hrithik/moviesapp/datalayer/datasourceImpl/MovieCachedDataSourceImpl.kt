package com.hrithik.moviesapp.datalayer.datasourceImpl

import com.hrithik.moviesapp.datalayer.datasource.MovieCachedDataSource
import com.hrithik.moviesapp.datalayer.model.Movie

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
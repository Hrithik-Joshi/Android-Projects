package com.hrithik.moviesapp.domainLayer.repository

import android.util.Log
import com.hrithik.moviesapp.dataLayer.datasource.MovieApiDataSource
import com.hrithik.moviesapp.dataLayer.datasource.MovieCachedDataSource
import com.hrithik.moviesapp.dataLayer.datasource.MovieLocalDataSource
import com.hrithik.moviesapp.dataLayer.model.Movie

class MovieRepositoryImpl(
    private val movieApiDataSource: MovieApiDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCachedDataSource: MovieCachedDataSource
) : MovieRepository {
    private lateinit var movieList: List<Movie>

    override suspend fun getAllMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newMoviesList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDb(newMoviesList)
        movieCachedDataSource.saveMoviesToCache(newMoviesList)
        return newMoviesList
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {

        try {
            val response = movieApiDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: java.lang.Exception) {
            Log.v("TAG1", "response body is null")
        }
        return movieList
    }

    private suspend fun getMoviesFromRoom(): List<Movie> {
        try {
            movieList = movieLocalDataSource.getMovieFromDb()
        } catch (exception: java.lang.Exception) {
            Log.v("TAG2", "movie list from db is empty")
        }
        if (movieList.isEmpty()) {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDb(movieList)
        }
        return movieList

    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        try {
            movieList = movieCachedDataSource.getMoviesFromCache()
        } catch (exception: java.lang.Exception) {
            Log.v("TAG3", "movie list from cache is empty")
        }

        if (movieList.isEmpty()) {
            movieList = getMoviesFromRoom()
            movieCachedDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}
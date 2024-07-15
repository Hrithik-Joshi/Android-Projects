package com.hrithik.moviesapp.dataLayer.datasourceImpl

import com.hrithik.moviesapp.dataLayer.datasource.MovieLocalDataSource
import com.hrithik.moviesapp.dataLayer.db.MovieDao
import com.hrithik.moviesapp.dataLayer.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMovieFromDb(): List<Movie> =
        movieDao.getAllMovies()

    override suspend fun saveMovieToDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }

}
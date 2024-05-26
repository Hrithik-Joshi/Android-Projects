package com.hrithik.moviesapp.datalayer.datasourceImpl

import com.hrithik.moviesapp.datalayer.datasource.MovieApiDataSource
import com.hrithik.moviesapp.datalayer.model.MovieList
import com.hrithik.moviesapp.datalayer.retrofit.TMDBApiService
import retrofit2.Response

class MovieApiDataSourceImpl(
    private val tmdbService: TMDBApiService,
    private val apiKey: String
) : MovieApiDataSource {

    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)


}
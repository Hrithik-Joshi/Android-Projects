package com.hrithik.moviesapp.dataLayer.datasourceImpl

import com.hrithik.moviesapp.dataLayer.datasource.MovieApiDataSource
import com.hrithik.moviesapp.dataLayer.model.MovieList
import com.hrithik.moviesapp.dataLayer.retrofit.TMDBApiService
import retrofit2.Response

class MovieApiDataSourceImpl(
    private val tmdbService: TMDBApiService,
    private val apiKey: String
) : MovieApiDataSource {

    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)


}
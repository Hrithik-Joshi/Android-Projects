package com.hrithik.moviesapp.dataLayer.datasource

import com.hrithik.moviesapp.dataLayer.model.MovieList
import retrofit2.Response

interface MovieApiDataSource {

    suspend fun getMovies() : Response<MovieList>
}
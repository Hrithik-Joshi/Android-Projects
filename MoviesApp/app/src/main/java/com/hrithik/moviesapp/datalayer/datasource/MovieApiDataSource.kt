package com.hrithik.moviesapp.datalayer.datasource

import com.hrithik.moviesapp.datalayer.model.MovieList
import retrofit2.Response

interface MovieApiDataSource {

    suspend fun getMovies() : Response<MovieList>
}
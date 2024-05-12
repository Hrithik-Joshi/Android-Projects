package com.hrithik.moviesapp.retrofit

import com.hrithik.moviesapp.data.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApiService {

    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String
    ) :Response<MovieList>
}
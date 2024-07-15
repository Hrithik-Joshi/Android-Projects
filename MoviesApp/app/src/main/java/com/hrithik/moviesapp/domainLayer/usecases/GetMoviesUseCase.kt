package com.hrithik.moviesapp.domainLayer.usecases

import com.hrithik.moviesapp.dataLayer.model.Movie
import com.hrithik.moviesapp.domainLayer.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getAllMovies()
}
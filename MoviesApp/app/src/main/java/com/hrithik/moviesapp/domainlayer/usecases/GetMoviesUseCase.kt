package com.hrithik.moviesapp.domainlayer.usecases

import com.hrithik.moviesapp.datalayer.model.Movie
import com.hrithik.moviesapp.domainlayer.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getAllMovies()
}
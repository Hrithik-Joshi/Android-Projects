package com.hrithik.moviesapp.datalayer.model

import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>
)

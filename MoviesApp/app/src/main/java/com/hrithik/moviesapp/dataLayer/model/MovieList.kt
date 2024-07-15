package com.hrithik.moviesapp.dataLayer.model

import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>
)

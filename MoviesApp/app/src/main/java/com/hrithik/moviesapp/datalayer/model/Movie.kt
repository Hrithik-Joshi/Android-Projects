package com.hrithik.moviesapp.datalayer.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName= "popular_movies")
data class Movie(
    @SerializedName("id")
    val movieId: Int,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("title")
    val title: String,

    )

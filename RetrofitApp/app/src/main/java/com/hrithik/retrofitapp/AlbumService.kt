package com.hrithik.retrofitapp

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("/albums")
    suspend fun getAllAlbums(): Response<Albums>
}
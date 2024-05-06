package com.hrithik.retrofitapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retrofitService.getAllAlbums()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumItems = it.body()?.iterator()

            if (albumItems != null) {
                while(albumItems.hasNext()){
                    val item = albumItems.next()
                    Log.i("AGGY",item.userId.toString())

                }
            }
        })
    }
}
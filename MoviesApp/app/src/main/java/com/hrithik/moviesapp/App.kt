package com.hrithik.moviesapp

import android.app.Application
import com.hrithik.moviesapp.presentationLayer.di.ApiDataSourceModule
import com.hrithik.moviesapp.presentationLayer.di.AppComponent
import com.hrithik.moviesapp.presentationLayer.di.AppModule
import com.hrithik.moviesapp.presentationLayer.di.DaggerAppComponent
import com.hrithik.moviesapp.presentationLayer.di.Injector
import com.hrithik.moviesapp.presentationLayer.di.MovieSubComponent
import com.hrithik.moviesapp.presentationLayer.di.NetModule

class App:Application(),Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .apiDataSourceModule(ApiDataSourceModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }


}
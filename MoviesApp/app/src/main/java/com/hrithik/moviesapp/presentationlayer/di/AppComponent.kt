package com.hrithik.moviesapp.presentationlayer.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CachedDataSourceModule::class,
        DatabaseModule::class,
        LocalDataSourceModule::class,
        NetModule::class,
        RepositoryModule::class,
        ApiDataSourceModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
}
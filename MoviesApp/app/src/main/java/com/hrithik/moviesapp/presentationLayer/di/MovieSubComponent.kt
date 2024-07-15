package com.hrithik.moviesapp.presentationLayer.di

import com.hrithik.moviesapp.presentationLayer.MainActivity
import dagger.Subcomponent
//MovieSubComponent: A subcomponent that inherits dependencies from a parent component
@MovieScope
@Subcomponent(modules = [ViewModelModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}
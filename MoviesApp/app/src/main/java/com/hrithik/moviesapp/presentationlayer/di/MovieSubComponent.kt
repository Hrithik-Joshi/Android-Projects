package com.hrithik.moviesapp.presentationlayer.di

import com.hrithik.moviesapp.MainActivity
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
package com.hrithik.moviesapp.presentationlayer.di

import javax.inject.Scope

//Custom scope annotation used to manage the lifecycle of dependencies within the MovieSubComponent.
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class MovieScope {
}
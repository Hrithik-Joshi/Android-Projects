// Top-level build file where you can add configuration options common to all sub-projects/modules.
val roomVersion by extra("2.6.1")
val coroutinesVersion by extra("1.7.3")

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    kotlin("kapt") version "1.9.23"
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
}
package com.hrithik.moviesapp.dataLayer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hrithik.moviesapp.dataLayer.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}
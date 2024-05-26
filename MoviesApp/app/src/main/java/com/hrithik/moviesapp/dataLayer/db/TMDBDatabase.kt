package com.hrithik.moviesapp.dataLayer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hrithik.moviesapp.dataLayer.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

}
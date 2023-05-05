package com.example.moviesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.data.database.dao.WatchlistMovieDao
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity

@Database(entities = [WatchlistMovieEntity::class], version = 1)
abstract class WatchlistMovieDatabase: RoomDatabase() {
    abstract fun getWatchListMovieDao(): WatchlistMovieDao
}
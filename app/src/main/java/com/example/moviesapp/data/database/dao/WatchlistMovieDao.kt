package com.example.moviesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity

@Dao
interface WatchlistMovieDao {
    @Query("SELECT * FROM watchlist_table")
    suspend fun getAllWatchlistMovies(): List<WatchlistMovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWatchlistMovies(watchlistMovieEntity: WatchlistMovieEntity)

    @Query("DELETE FROM watchlist_table WHERE idWatchlist = :idWatchlist")
    suspend fun removeWatchlistMovie(idWatchlist: String)
}
package com.example.moviesapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesapp.ui.domain.MovieItem
import com.example.moviesapp.ui.domain.UpcomingMovieItem

@Entity(tableName = "watchlist_table")
data class WatchlistMovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "idWatchlist") val idWatchlist: String,
    @ColumnInfo(name = "poster_path") val poster : String,
)

fun MovieItem.toDatabase() = WatchlistMovieEntity(idWatchlist = id, poster = poster)
fun UpcomingMovieItem.toDatabase() = WatchlistMovieEntity(idWatchlist = id, poster = poster)
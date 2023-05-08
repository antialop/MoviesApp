package com.example.moviesapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesapp.ui.domain.PopularMovie
import com.example.moviesapp.ui.domain.PopularMovieItem

@Entity(tableName = "watchlist_table")
data class WatchlistMovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "idWatchlist") val idWatchlist: String
)

fun PopularMovieItem.toDatabase() = WatchlistMovieEntity(idWatchlist = id)
package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.MoviesRespository
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import javax.inject.Inject

class InsertWatchlistMovieUseCase @Inject constructor(
    private val repository: MoviesRespository
) {
    suspend operator fun invoke(watchlistMovieEntity: WatchlistMovieEntity){
        repository.insertWatchlistMovie((watchlistMovieEntity))
    }
}
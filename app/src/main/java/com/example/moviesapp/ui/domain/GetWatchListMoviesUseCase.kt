package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.MoviesRespository
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import javax.inject.Inject

class GetWatchListMoviesUseCase @Inject constructor(
    private val repository: MoviesRespository
) {
    suspend operator fun invoke():List<WatchlistMovieEntity>{

        return  repository.getWatchlistFromDatabase()
    }
}
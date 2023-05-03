package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.MoviesRespository
import javax.inject.Inject

class MoviesDetailsUseCase @Inject constructor(
    private val repository: MoviesRespository
) {
    suspend operator fun invoke(movieId:String) = repository.getMoviesDetailsFromApi(movieId)
}
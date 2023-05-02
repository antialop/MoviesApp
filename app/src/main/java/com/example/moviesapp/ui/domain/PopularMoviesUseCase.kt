package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.MoviesRespository
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(
    private val repository: MoviesRespository
) {
    suspend operator fun invoke() = repository.getPopularMoviesFromApi()
}
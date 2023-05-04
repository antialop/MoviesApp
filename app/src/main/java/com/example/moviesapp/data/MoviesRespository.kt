package com.example.moviesapp.data

import com.example.moviesapp.data.network.MoviesService
import com.example.moviesapp.ui.domain.PopularMovie
import com.example.moviesapp.ui.domain.MovieDetail
import com.example.moviesapp.ui.domain.SearchMovie
import com.example.moviesapp.ui.domain.UpcomingMovie
import com.example.moviesapp.ui.domain.toDomain
import javax.inject.Inject

class MoviesRespository @Inject constructor(
    private val api:MoviesService
) {
    suspend fun getPopularMoviesFromApi():PopularMovie{
        return api.getPopular().toDomain()
    }
    suspend fun getMoviesDetailsFromApi(movieId:String):MovieDetail{
        return api.getMovieInformation(movieId).toDomain()
    }
    suspend fun  getMoviesByNameFromApi(movie:String): SearchMovie{
        return api.getMoviesByName(movie).toDomain()
    }
    suspend fun getUpcomingMoviesFromApi():UpcomingMovie{
        return api.getUpcoming().toDomain()
    }
}
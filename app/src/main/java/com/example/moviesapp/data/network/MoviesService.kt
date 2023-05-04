package com.example.moviesapp.data.network

import com.example.moviesapp.data.network.model.MovieDetailResponse
import com.example.moviesapp.data.network.model.PopularMovieResponse
import com.example.moviesapp.data.network.model.SearchMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesService @Inject constructor(private val api:MoviesApi) {

    suspend fun getPopular(): PopularMovieResponse {
        return withContext(Dispatchers.IO){
            val response = api.getPopularMovies()
            response.body()!!
        }
    }
    suspend fun getMovieInformation(movieId:String): MovieDetailResponse{
        return withContext(Dispatchers.IO){
            val response = api.getMoviesDetails(movieId)
            response.body()!!
        }
    }
    suspend fun getMoviesByName(movie:String): SearchMovieResponse{
        return withContext(Dispatchers.IO){
            val response = api.getMoviesByName(movie)
            response.execute().body()!!
        }
    }
}
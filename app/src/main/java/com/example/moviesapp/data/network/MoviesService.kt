package com.example.moviesapp.data.network

import com.example.moviesapp.data.network.model.MovieDetailResponse
import com.example.moviesapp.data.network.model.MovieResponse
import com.example.moviesapp.data.network.model.TopRatedMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesService @Inject constructor(private val api:MoviesApi) {

    suspend fun getPopular(): MovieResponse {
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
    suspend fun getMoviesByName(movie:String): MovieResponse{
        return withContext(Dispatchers.IO) {
            val response = api.getMoviesByName(movie)
            response.execute().body()!!
        }
    }

    suspend fun getRated(): TopRatedMovieResponse {
        return withContext(Dispatchers.IO){
            val response = api.getRatedMovies()
            response.body()!!
        }
    }
}
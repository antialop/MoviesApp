package com.example.moviesapp.data.network

import com.example.moviesapp.data.network.model.PopularMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MoviesService @Inject constructor(private val api:MoviesApi) {

    suspend fun getPopular(): PopularMovieResponse {
        return withContext(Dispatchers.IO){
            val response = api.getPopularMovies()
            response.body()!!
        }
    }
}
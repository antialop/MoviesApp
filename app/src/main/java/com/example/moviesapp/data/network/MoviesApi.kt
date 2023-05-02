package com.example.moviesapp.data.network

import com.example.moviesapp.data.network.model.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular")
    fun getSuperheroes(
        @Query("api_key") apiKey: String,
    ): Call<PopularMovieResponse>
}
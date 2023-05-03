package com.example.moviesapp.data.network

import com.example.moviesapp.data.network.model.MovieDetailResponse
import com.example.moviesapp.data.network.model.PopularMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {
    @GET("movie/popular?api_key=9d7a4356804c3e6ac96557bcc4ee5ba4")
    suspend fun getPopularMovies(): Response<PopularMovieResponse>

    @GET("movie/{id}?api_key=9d7a4356804c3e6ac96557bcc4ee5ba4")
    suspend fun getMoviesDetails(@Path("id") movieId:String):Response<MovieDetailResponse>
}
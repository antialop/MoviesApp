package com.example.moviesapp.data.network

import com.example.moviesapp.data.network.model.MovieDetailResponse
import com.example.moviesapp.data.network.model.PopularMovieResponse
import com.example.moviesapp.data.network.model.SearchMovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular?api_key=9d7a4356804c3e6ac96557bcc4ee5ba4")
    suspend fun getPopularMovies(): Response<PopularMovieResponse>

    @GET("movie/{id}?api_key=9d7a4356804c3e6ac96557bcc4ee5ba4")
    suspend fun getMoviesDetails(@Path("id") movieId:String):Response<MovieDetailResponse>

    @GET("search/movie?api_key=9d7a4356804c3e6ac96557bcc4ee5ba4")
    fun getMoviesByName(@Query("query") query: String): Call<SearchMovieResponse>
}
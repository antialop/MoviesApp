package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.network.model.TopRatedMovieResponse
import com.google.gson.annotations.SerializedName

data class TopReatedMovie(
    //val date: Dates,
    val page: Int,
    val upcomingMovies: List<TopRatedMovieItem>,
    val total: Int,
    val pages: Int,
)

data class Dates(
    @SerializedName("maximum") val maximum: String,
    @SerializedName("minimum") val minimum: String,
)

data class TopRatedMovieItem(
    @SerializedName("id") var id: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("original_title") val name: String,
    var esFavorito:Boolean = false
)
fun TopRatedMovieResponse.toDomain() = TopReatedMovie(page,upcomingMovies,total,pages)
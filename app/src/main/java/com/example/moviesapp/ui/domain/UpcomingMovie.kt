package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.network.model.PopularMovieResponse
import com.example.moviesapp.data.network.model.UpcomingMovieResponse
import com.google.gson.annotations.SerializedName

data class UpcomingMovie(
    val date: Dates,
    val page: Int,
    val popularMovies: List<UpcomingMovieItem>,
    val total: Int,
    val pages: Int,
)

data class Dates(
    @SerializedName("maximum") val maximum: String,
    @SerializedName("minimum") val minimum: String,
)

data class UpcomingMovieItem(
    @SerializedName("id") var id: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("original_title") val name: String
)
fun UpcomingMovieResponse.toDomain() = UpcomingMovie(date,page,popularMovies,total,pages)
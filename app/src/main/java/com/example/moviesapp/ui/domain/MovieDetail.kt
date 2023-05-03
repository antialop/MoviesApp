package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.network.model.MovieDetailResponse
import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("original_title") val original_title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("budget") val budget: Long,
    @SerializedName("revenue") val revenue: Long,
)


fun MovieDetailResponse.toDomain() = MovieDetail(
    original_title, overview, poster_path, release_date, runtime, budget, revenue)

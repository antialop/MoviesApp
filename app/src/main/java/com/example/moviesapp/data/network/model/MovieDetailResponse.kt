package com.example.moviesapp.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("original_title") val original_title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("budget") val budget: Long,
    @SerializedName("revenue") val revenue: Long,
)
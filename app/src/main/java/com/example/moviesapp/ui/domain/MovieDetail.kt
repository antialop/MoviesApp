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
    @SerializedName("belongs_to_collection") val belongs_to_collection: BelongCollection
)

data class BelongCollection(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val poster: String
)

fun MovieDetailResponse.toDomain() = MovieDetail(
    original_title, overview, poster_path, release_date, runtime, budget, revenue,belongs_to_collection)

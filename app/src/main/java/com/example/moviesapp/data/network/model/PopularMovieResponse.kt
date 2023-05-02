package com.example.moviesapp.data.network.model

import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val popularMovies: List<PopularMovieItem>,
    @SerializedName("total_results") val total: Int,
    @SerializedName("total_pages") val pages: Int,
)

data class PopularMovieItem(
    @SerializedName("poster_path") var poster: String,
    @SerializedName("original_title") val name: String
)
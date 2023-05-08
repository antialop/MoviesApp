package com.example.moviesapp.data.network.model

import com.example.moviesapp.ui.domain.MovieItem
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val popularMovies: List<MovieItem>,
    @SerializedName("total_results") val total: Int,
    @SerializedName("total_pages") val pages: Int,
)


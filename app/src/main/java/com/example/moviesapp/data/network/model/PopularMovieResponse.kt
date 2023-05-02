package com.example.moviesapp.data.network.model

import com.example.moviesapp.ui.domain.PopularMovieItem
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val popularMovies: List<PopularMovieItem>,
    @SerializedName("total_results") val total: Int,
    @SerializedName("total_pages") val pages: Int,
)


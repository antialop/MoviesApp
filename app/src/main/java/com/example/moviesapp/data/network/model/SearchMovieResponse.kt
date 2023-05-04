package com.example.moviesapp.data.network.model

import com.example.moviesapp.ui.domain.SearchMovieItem
import com.google.gson.annotations.SerializedName

data class SearchMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movie: List<SearchMovieItem>,
    @SerializedName("total_results") val total: Int,
    @SerializedName("total_pages") val pages: Int,
)


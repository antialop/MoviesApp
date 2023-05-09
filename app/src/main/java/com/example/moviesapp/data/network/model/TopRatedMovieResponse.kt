package com.example.moviesapp.data.network.model

import com.example.moviesapp.ui.domain.TopRatedMovieItem
import com.google.gson.annotations.SerializedName

data class TopRatedMovieResponse (
    //@SerializedName("dates") val date: Dates,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val upcomingMovies: List<TopRatedMovieItem>,
    @SerializedName("total_results") val total: Int,
    @SerializedName("total_pages") val pages: Int,
)

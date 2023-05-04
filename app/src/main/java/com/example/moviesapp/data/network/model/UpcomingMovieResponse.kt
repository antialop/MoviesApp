package com.example.moviesapp.data.network.model

import com.example.moviesapp.ui.domain.Dates
import com.example.moviesapp.ui.domain.UpcomingMovieItem
import com.google.gson.annotations.SerializedName

data class UpcomingMovieResponse (
    @SerializedName("dates") val date: Dates,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val upcomingMovies: List<UpcomingMovieItem>,
    @SerializedName("total_results") val total: Int,
    @SerializedName("total_pages") val pages: Int,
)

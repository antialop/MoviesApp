package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.network.model.PopularMovieResponse
import com.example.moviesapp.data.network.model.SearchMovieResponse
import com.google.gson.annotations.SerializedName

data class SearchMovie(
    val page: Int,
    val movie: List<SearchMovieItem>,
    val total: Int,
    val pages: Int,
)

data class SearchMovieItem(
    @SerializedName("id") var id: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("original_title") val name: String
)
fun SearchMovieResponse.toDomain() = SearchMovie(page,movie,total,pages)
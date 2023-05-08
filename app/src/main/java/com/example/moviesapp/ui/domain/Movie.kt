package com.example.moviesapp.ui.domain

import com.example.moviesapp.data.network.model.MovieResponse
import com.google.gson.annotations.SerializedName

data class Movie(
    val page: Int,
    val popularMovies: List<MovieItem>,
    val total: Int,
    val pages: Int,
)

data class MovieItem(
    @SerializedName("id") var id: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("original_title") val name: String,
    var esFavorito:Boolean = false

)
fun MovieResponse.toDomain() = Movie(page,popularMovies,total,pages)
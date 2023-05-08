package com.example.moviesapp.ui.domain

import android.graphics.pdf.PdfDocument.Page
import com.example.moviesapp.data.network.model.PopularMovieResponse
import com.google.gson.annotations.SerializedName

data class PopularMovie(
    val page: Int,
    val popularMovies: List<PopularMovieItem>,
    val total: Int,
    val pages: Int,
)

data class PopularMovieItem(
    @SerializedName("id") var id: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("original_title") val name: String,
    var esFavorito:Boolean = false

)
fun PopularMovieResponse.toDomain() = PopularMovie(page,popularMovies,total,pages)
package com.example.moviesapp.ui.home.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.ItemPopularMovieBinding
import com.example.moviesapp.ui.domain.PopularMovieItem
import com.squareup.picasso.Picasso

class PopularMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemPopularMovieBinding.bind(view)

    fun bind(popularMovieItem: PopularMovieItem) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500"+popularMovieItem.poster)
            .into(binding.ivPopularMovie)
    }
}
package com.example.moviesapp.ui.home.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.ItemMovieBinding
import com.example.moviesapp.databinding.ItemPopularMovieBinding
import com.example.moviesapp.ui.domain.UpcomingMovieItem
import com.squareup.picasso.Picasso

class UpcomingMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPopularMovieBinding.bind(view)

    fun bind(upcomingMovieItem: UpcomingMovieItem, onItemSelected: (String) -> Unit) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500" + upcomingMovieItem.poster)
            .into(binding.ivPopularMovie)
        binding.root.setOnClickListener {
            //Cada vez que se pulse la lista le pasamos el id
            onItemSelected(upcomingMovieItem.id)
        }
    }
}
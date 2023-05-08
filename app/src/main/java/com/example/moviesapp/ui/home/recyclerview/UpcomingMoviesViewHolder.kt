package com.example.moviesapp.ui.home.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ItemPopularMovieBinding
import com.example.moviesapp.ui.domain.UpcomingMovieItem
import com.squareup.picasso.Picasso

class UpcomingMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPopularMovieBinding.bind(view)

    fun bind(upcomingMovieItem: UpcomingMovieItem,
             onItemSelected: (String) -> Unit,
             addWatchlist: (UpcomingMovieItem) -> Unit,
             removeWatchlist: (String) -> Unit) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500" + upcomingMovieItem.poster)
            .into(binding.ivPopularMovie)
        binding.root.setOnClickListener {
            //Cada vez que se pulse la lista le pasamos el id
            onItemSelected(upcomingMovieItem.id)
        }
        binding.watchlistMovie.setOnClickListener {
            if (!upcomingMovieItem.esFavorito) {
                binding.watchlistMovie.setImageResource(R.drawable.ic_added_to_watchlist)
                addWatchlist(upcomingMovieItem)
                Log.i("favorie", upcomingMovieItem.toString())
                upcomingMovieItem.esFavorito = !upcomingMovieItem.esFavorito
            } else {
                binding.watchlistMovie.setImageResource(R.drawable.ic_add_to_watchlist)
                removeWatchlist(upcomingMovieItem.id)
                upcomingMovieItem.esFavorito = !upcomingMovieItem.esFavorito
            }
        }
    }
}
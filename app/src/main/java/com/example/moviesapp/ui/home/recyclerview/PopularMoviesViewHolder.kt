package com.example.moviesapp.ui.home.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ItemPopularMovieBinding
import com.example.moviesapp.ui.domain.MovieItem
import com.squareup.picasso.Picasso

class PopularMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemPopularMovieBinding.bind(view)

    fun bind(
        popularMovieItem: MovieItem,
        onItemSelected: (String) -> Unit,
        addWatchlist: (MovieItem) -> Unit,
        removeWatchlist: (String) -> Unit) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500" + popularMovieItem.poster)
            .into(binding.ivPopularMovie)
        binding.root.setOnClickListener {
            //Cada vez que se pulse la lista le pasamos el id
            onItemSelected(popularMovieItem.id)
        }
        binding.watchlistMovie.setOnClickListener {
            if (!popularMovieItem.esFavorito) {
                binding.watchlistMovie.setImageResource(R.drawable.ic_added_to_watchlist)
                addWatchlist(popularMovieItem)
                Log.i("favorite", popularMovieItem.toString())
                popularMovieItem.esFavorito = !popularMovieItem.esFavorito
            } else {
                binding.watchlistMovie.setImageResource(R.drawable.ic_add_to_watchlist)
                removeWatchlist(popularMovieItem.id)
                popularMovieItem.esFavorito = !popularMovieItem.esFavorito
            }
        }
    }
}
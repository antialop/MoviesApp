package com.example.moviesapp.ui.home.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ItemPopularMovieBinding
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.domain.TopRatedMovieItem
import com.squareup.picasso.Picasso

class TopRatedMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPopularMovieBinding.bind(view)

    fun bind(upcomingMovieItem: TopRatedMovieItem,
             onItemSelected: (String) -> Unit,
             addWatchlist: (TopRatedMovieItem) -> Unit,
             removeWatchlist: (String) -> Unit) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500" + upcomingMovieItem.poster)
            .into(binding.ivPopularMovie)
        binding.root.setOnClickListener {
            //Cada vez que se pulse la lista le pasamos el id
            onItemSelected(upcomingMovieItem.id)
        }
        if(containsMovie(upcomingMovieItem)){
            binding.watchlistMovie.setImageResource((R.drawable.ic_added_to_watchlist))
        }else{
            binding.watchlistMovie.setImageResource((R.drawable.ic_add_to_watchlist))
        }
        binding.watchlistMovie.setOnClickListener {
            if (!containsMovie(upcomingMovieItem)) {
                binding.watchlistMovie.setImageResource(R.drawable.ic_added_to_watchlist)
                addWatchlist(upcomingMovieItem)
                Log.i("favoriteUpcoming", upcomingMovieItem.toString())
                //searchMovieItem.esFavorito = !searchMovieItem.esFavorito
            } else {
                binding.watchlistMovie.setImageResource(R.drawable.ic_add_to_watchlist)
                removeWatchlist(upcomingMovieItem.id)
                //searchMovieItem.esFavorito = !searchMovieItem.esFavorito

            }
        }
    }
    private fun containsMovie(upcomingMovieItem: TopRatedMovieItem): Boolean{
        MainActivity.watchlist.forEach {
            if(it.idMovieWatchlist ==upcomingMovieItem.id) return true
        }
        return false
    }

}
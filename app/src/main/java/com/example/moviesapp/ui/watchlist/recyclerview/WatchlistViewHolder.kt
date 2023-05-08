package com.example.moviesapp.ui.watchlist.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import com.example.moviesapp.databinding.ItemPopularMovieBinding
import com.example.moviesapp.ui.domain.MovieItem
import com.squareup.picasso.Picasso

class WatchlistViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemPopularMovieBinding.bind(view)



    fun bind(watchlistMovieEntity: WatchlistMovieEntity,
             onItemSelected: (String) -> Unit,
             addWatchlist: (WatchlistMovieEntity) -> Unit,
             removeWatchlist: (String) -> Unit) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500" + watchlistMovieEntity.poster)
            .into(binding.ivPopularMovie)
        binding.root.setOnClickListener {
            //Cada vez que se pulse la lista le pasamos el id
            onItemSelected(watchlistMovieEntity.idWatchlist)
        }
        binding.watchlistMovie.setImageResource(R.drawable.ic_added_to_watchlist)
        binding.watchlistMovie.setOnClickListener {
            removeWatchlist(watchlistMovieEntity.idWatchlist)

        }
    }
}
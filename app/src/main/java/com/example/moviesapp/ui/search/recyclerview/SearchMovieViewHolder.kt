package com.example.moviesapp.ui.search.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ItemPopularMovieBinding
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.domain.MovieItem
import com.squareup.picasso.Picasso

class SearchMovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemPopularMovieBinding.bind(view)

    fun bind(searchMovieItem: MovieItem,
             onItemSelected: (String) -> Unit,
             addWatchlist: (MovieItem) -> Unit,
             removeWatchlist: (String) -> Unit) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500"+searchMovieItem.poster)
            .into(binding.ivPopularMovie)
        binding.root.setOnClickListener {
            //Cada vez que se pulse la lista le pasamos el id
            onItemSelected(searchMovieItem.id)
        }
        if(containsMovie(searchMovieItem)){
            binding.watchlistMovie.setImageResource((R.drawable.ic_added_to_watchlist))
        }else{
            binding.watchlistMovie.setImageResource((R.drawable.ic_add_to_watchlist))
        }
        binding.watchlistMovie.setOnClickListener {
            if (!containsMovie(searchMovieItem)) {
                binding.watchlistMovie.setImageResource(R.drawable.ic_added_to_watchlist)
                addWatchlist(searchMovieItem)
                Log.i("favorite", searchMovieItem.toString())
                //searchMovieItem.esFavorito = !searchMovieItem.esFavorito
            } else {
                binding.watchlistMovie.setImageResource(R.drawable.ic_add_to_watchlist)
                removeWatchlist(searchMovieItem.id)
                //searchMovieItem.esFavorito = !searchMovieItem.esFavorito

            }
        }
    }
    private fun containsMovie(searchMovieItem: MovieItem): Boolean{
        MainActivity.watchlist.forEach {
            if(it.idMovieWatchlist ==searchMovieItem.id) return true
        }
        return false
    }


}
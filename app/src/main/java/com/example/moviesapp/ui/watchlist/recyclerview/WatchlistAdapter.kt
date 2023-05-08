package com.example.moviesapp.ui.watchlist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import com.example.moviesapp.ui.domain.MovieItem

class WatchlistAdapter(
    private var watchlistMovieEntity: List<WatchlistMovieEntity> = emptyList(),
    private val onItemSelected:(String) -> Unit,
    private val addWatchlistMovie: (WatchlistMovieEntity) -> Unit,
    private val removeWatchlistMovie: (String) -> Unit
):RecyclerView.Adapter<WatchlistViewHolder>() {

    fun updateList(watchlist: List<WatchlistMovieEntity>) {
        this.watchlistMovieEntity = watchlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WatchlistViewHolder(
            layoutInflater.inflate(
                R.layout.item_popular_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return watchlistMovieEntity.size
    }

    override fun onBindViewHolder(viewHolder: WatchlistViewHolder, position: Int) {
        viewHolder.bind(watchlistMovieEntity[position],onItemSelected,addWatchlistMovie,removeWatchlistMovie)

    }

}
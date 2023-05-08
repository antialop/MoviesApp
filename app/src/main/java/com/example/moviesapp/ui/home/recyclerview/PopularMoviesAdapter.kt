package com.example.moviesapp.ui.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.ui.domain.MovieItem

class PopularMoviesAdapter (
    private var popularMoviesList: List<MovieItem> = emptyList(),
    private val onItemSelected:(String) -> Unit,
    private val addWatchlistMovie: (MovieItem) -> Unit,
    private val removeWatchlisMovie: (String) -> Unit

) : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    fun updateList(popularList: List<MovieItem>) {
        this.popularMoviesList = popularList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PopularMoviesViewHolder(
            layoutInflater.inflate(
                R.layout.item_popular_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return popularMoviesList.size
    }

    override fun onBindViewHolder(viewHolder: PopularMoviesViewHolder, position: Int) {
        viewHolder.bind(popularMoviesList[position],onItemSelected,addWatchlistMovie,removeWatchlisMovie)
    }
}
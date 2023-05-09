package com.example.moviesapp.ui.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.ui.domain.TopRatedMovieItem


class TopRatedMoviesAdapter(
    private var upcomingMovieList: List<TopRatedMovieItem> = emptyList(),
    private val onItemSelected: (String) -> Unit,
    private val addWatchlistMovie: (TopRatedMovieItem) -> Unit,
    private val removeWatchlistMovie: (String) -> Unit

) : RecyclerView.Adapter<TopRatedMoviesViewHolder>() {

    fun updateList(upcomingList: List<TopRatedMovieItem>) {
        this.upcomingMovieList = upcomingList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TopRatedMoviesViewHolder(
            layoutInflater.inflate(
                R.layout.item_popular_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return upcomingMovieList.size
    }

    override fun onBindViewHolder(viewHolder: TopRatedMoviesViewHolder, position: Int) {
        viewHolder.bind(upcomingMovieList[position],onItemSelected,addWatchlistMovie,removeWatchlistMovie)
    }

}
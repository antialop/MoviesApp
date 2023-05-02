package com.example.moviesapp.ui.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.ui.domain.PopularMovieItem
import javax.inject.Inject

class PopularMoviesAdapter @Inject constructor(
    private var popularMoviesList: List<PopularMovieItem>
) : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    fun updateList(superheroList: List<PopularMovieItem>) {
        this.popularMoviesList = superheroList
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
        viewHolder.bind(popularMoviesList[position])
    }
}
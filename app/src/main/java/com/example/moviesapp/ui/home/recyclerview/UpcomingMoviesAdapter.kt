package com.example.moviesapp.ui.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.ui.domain.PopularMovieItem
import com.example.moviesapp.ui.domain.UpcomingMovieItem


class UpcomingMoviesAdapter(
    private var upcomingMovieList: List<UpcomingMovieItem>,
    private val onItemSelected: (String) -> Unit

) : RecyclerView.Adapter<UpcomingMoviesViewHolder>() {

    fun updateList(upcomingList: List<UpcomingMovieItem>) {
        this.upcomingMovieList = upcomingList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UpcomingMoviesViewHolder(
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

    override fun onBindViewHolder(viewHolder: UpcomingMoviesViewHolder, position: Int) {
        viewHolder.bind(upcomingMovieList[position],onItemSelected)
    }

}
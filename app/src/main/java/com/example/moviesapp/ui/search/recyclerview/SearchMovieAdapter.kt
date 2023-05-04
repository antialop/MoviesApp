package com.example.moviesapp.ui.search.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.ui.domain.SearchMovieItem


class SearchMovieAdapter(
     private var searchMovieList: List<SearchMovieItem>,
     private val onItemSelected:(String) -> Unit
) : RecyclerView.Adapter<SearchMovieViewHolder>() {

    fun updateList(searchList: List<SearchMovieItem>) {
        this.searchMovieList = searchList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchMovieViewHolder(
            layoutInflater.inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return searchMovieList.size
    }

    override fun onBindViewHolder(viewHolder: SearchMovieViewHolder, position: Int) {
        viewHolder.bind(searchMovieList[position],onItemSelected)
    }
}
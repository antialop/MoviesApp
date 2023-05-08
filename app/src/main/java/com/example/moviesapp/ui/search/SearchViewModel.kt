package com.example.moviesapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.database.entities.toDatabase
import com.example.moviesapp.ui.domain.GetWatchListMoviesUseCase
import com.example.moviesapp.ui.domain.InsertWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.MovieItem
import com.example.moviesapp.ui.domain.RemoveWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    var getSearchMoviesUseCase: SearchMoviesUseCase,
    private val insertWatchlistMovieUseCase: InsertWatchlistMovieUseCase,
    private val removeWatchlistMovieUseCase: RemoveWatchlistMovieUseCase,
    private val getWatchListMoviesUseCase: GetWatchListMoviesUseCase,

):ViewModel() {

    val searchMovie = MutableLiveData<List<MovieItem>>()
    fun movieSearchByName(query: String){
        viewModelScope.launch {
            val result = getSearchMoviesUseCase(query)
            //Log.i("SearchcallApi", result.popularMovies.toString())
            searchMovie.postValue(result.popularMovies!!)
        }
    }
    fun insertWatchlistPopularMovie(popularMovieItem: MovieItem){
        viewModelScope.launch {
            insertWatchlistMovieUseCase(popularMovieItem.toDatabase())
        }
    }

    fun deleteWatchlistMovie(popularMovieId: String){
        viewModelScope.launch {
            removeWatchlistMovieUseCase(popularMovieId)
        }
    }
    fun getAllWatchlistMovie(){
        viewModelScope.launch {
            val result = getWatchListMoviesUseCase()
            Log.i("watchlist", result.toString())

        }
    }
}
package com.example.moviesapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.database.entities.toDatabase
import com.example.moviesapp.data.network.model.Watchlist
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.domain.GetWatchListMoviesUseCase
import com.example.moviesapp.ui.domain.InsertWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.MovieItem
import com.example.moviesapp.ui.domain.PopularMoviesUseCase
import com.example.moviesapp.ui.domain.RemoveWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.TopRatedMovieItem
import com.example.moviesapp.ui.domain.TopRatedMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var getPopularMoviesUseCase: PopularMoviesUseCase,
    var topRatedMovieUseCase: TopRatedMovieUseCase,
    private val insertWatchlistMovieUseCase: InsertWatchlistMovieUseCase,
    private val removeWatchlistMovieUseCase: RemoveWatchlistMovieUseCase,
    private val getWatchListMoviesUseCase: GetWatchListMoviesUseCase,

    ):ViewModel() {

    val popularMovie = MutableLiveData<List<MovieItem>>()
    val upcomingMovie = MutableLiveData<List<TopRatedMovieItem>>()

    fun allPopularMovies(){
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            Log.i("PopularcallApi", result.popularMovies.toString())
           popularMovie.postValue(result.popularMovies!!)
        }
    }
    fun allUpcomingMovies(){
        viewModelScope.launch {
            val result = topRatedMovieUseCase()
            Log.i("UpcomingcallApi", result.upcomingMovies.toString())
            upcomingMovie.postValue(result.upcomingMovies!!)
        }
    }
    fun insertWatchlistPopularMovie(popularMovieItem: MovieItem){
        viewModelScope.launch {
           insertWatchlistMovieUseCase(popularMovieItem.toDatabase())
            MainActivity.watchlist.add(Watchlist(popularMovieItem.id))
        }
    }
    fun insertWatchlistRatedMovie(topRatedMovieItem: TopRatedMovieItem){
        viewModelScope.launch {
            insertWatchlistMovieUseCase(topRatedMovieItem.toDatabase())
            MainActivity.watchlist.add(Watchlist(topRatedMovieItem.id))
        }
    }

    fun deleteWatchlistMovie(popularMovieId: String){
        viewModelScope.launch {
           removeWatchlistMovieUseCase(popularMovieId)
            MainActivity.watchlist.remove(Watchlist(popularMovieId))
        }
    }
    fun getAllWatchlistMovie(){
        viewModelScope.launch {
            val result = getWatchListMoviesUseCase()
            result.forEach {MainActivity.watchlist.add(Watchlist(it.idWatchlist))}
            Log.i("watchlist", result.toString())
        }
    }


}
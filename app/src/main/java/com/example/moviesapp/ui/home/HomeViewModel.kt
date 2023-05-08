package com.example.moviesapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.database.entities.toDatabase
import com.example.moviesapp.ui.domain.InsertWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.MovieItem
import com.example.moviesapp.ui.domain.PopularMoviesUseCase
import com.example.moviesapp.ui.domain.RemoveWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.UpcomingMovieItem
import com.example.moviesapp.ui.domain.UpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var getPopularMoviesUseCase: PopularMoviesUseCase,
    var getUpcomingMoviesUseCase: UpcomingMoviesUseCase,
    private val insertWatchlistMovieUseCase: InsertWatchlistMovieUseCase,
    private val removeWatchlistMovieUseCase: RemoveWatchlistMovieUseCase,

):ViewModel() {

    val popularMovie = MutableLiveData<List<MovieItem>>()
    val upcomingMovie = MutableLiveData<List<UpcomingMovieItem>>()

    fun allPopularMovies(){
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            Log.i("PopularcallApi", result.popularMovies.toString())
           popularMovie.postValue(result.popularMovies!!)
        }
    }
    fun allUpcomingMovies(){
        viewModelScope.launch {
            val result = getUpcomingMoviesUseCase()
            Log.i("UpcomingcallApi", result.upcomingMovies.toString())
            upcomingMovie.postValue(result.upcomingMovies!!)
        }
    }
    fun insertWatchlistPopularMovie(popularMovieItem: MovieItem){
        viewModelScope.launch {
           insertWatchlistMovieUseCase(popularMovieItem.toDatabase())
        }
    }
    fun insertWatchlistUpcomingMovie(upcomingMovieItem: UpcomingMovieItem){
        viewModelScope.launch {
            insertWatchlistMovieUseCase(upcomingMovieItem.toDatabase())
        }
    }

    fun deleteWatchlistMovie(popularMovieId: String){
        viewModelScope.launch {
           removeWatchlistMovieUseCase(popularMovieId)
        }
    }


}
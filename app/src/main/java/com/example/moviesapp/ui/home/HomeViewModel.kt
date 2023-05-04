package com.example.moviesapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.ui.domain.PopularMovieItem
import com.example.moviesapp.ui.domain.PopularMoviesUseCase
import com.example.moviesapp.ui.domain.UpcomingMovieItem
import com.example.moviesapp.ui.domain.UpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var getPopularMoviesUseCase: PopularMoviesUseCase,
    var getUpcomingMoviesUseCase: UpcomingMoviesUseCase

):ViewModel() {

    val popularMovie = MutableLiveData<List<PopularMovieItem>>()
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
}
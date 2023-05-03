package com.example.moviesapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.ui.domain.MovieDetail
import com.example.moviesapp.ui.domain.MoviesDetailsUseCase
import com.example.moviesapp.ui.domain.PopularMovieItem
import com.example.moviesapp.ui.domain.PopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var getPopularMoviesUseCase: PopularMoviesUseCase,
    var getMoviesDetailsUseCase: MoviesDetailsUseCase
):ViewModel() {

    val popularMovie = MutableLiveData<List<PopularMovieItem>>()
    val detailsMovie = MutableLiveData<List<MovieDetail>>()

    fun allPopularMovies(){
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            Log.i("callApi", result.popularMovies.toString())
           popularMovie.postValue(result.popularMovies!!)
        }
    }
    fun allDetailsMovie(id:String){
        viewModelScope.launch {
            val result = getMoviesDetailsUseCase(id)
            Log.i("callApiDetails", result.toString())
            detailsMovie.postValue(listOf(result))
        }
    }
}
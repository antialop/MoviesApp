package com.example.moviesapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.ui.domain.MovieDetail
import com.example.moviesapp.ui.domain.MoviesDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    var getMoviesDetailsUseCase: MoviesDetailsUseCase
): ViewModel(){
    val detailsMovie = MutableLiveData<MovieDetail>()
    fun allDetailsMovie(id:String){
        viewModelScope.launch {
            val result = getMoviesDetailsUseCase(id)
            Log.i("callApiDetails", result.toString())
            detailsMovie.postValue(result)
        }
    }
}
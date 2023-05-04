package com.example.moviesapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.ui.domain.SearchMovieItem
import com.example.moviesapp.ui.domain.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    var getSearchMoviesUseCase: SearchMoviesUseCase
):ViewModel() {

    val searchMovie = MutableLiveData<List<SearchMovieItem>>()
    fun movieSearchByName(){
        viewModelScope.launch {
            val result = getSearchMoviesUseCase("harry")
            Log.i("SearchcallApi", result.movie.toString())
            searchMovie.postValue(result.movie!!)
        }
    }
}
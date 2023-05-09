package com.example.moviesapp.ui.watchlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import com.example.moviesapp.data.database.entities.toDatabase
import com.example.moviesapp.data.network.model.Watchlist
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.domain.GetWatchListMoviesUseCase
import com.example.moviesapp.ui.domain.InsertWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.MovieItem
import com.example.moviesapp.ui.domain.RemoveWatchlistMovieUseCase
import com.example.moviesapp.ui.domain.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val getWatchListMoviesUseCase: GetWatchListMoviesUseCase,
    private val removeWatchlistMovieUseCase: RemoveWatchlistMovieUseCase,
    private val insertWatchlistMovieUseCase: InsertWatchlistMovieUseCase
):ViewModel() {

    val watchlistMovie = MutableLiveData<List<WatchlistMovieEntity>>()

    fun allWatchlistMovies(){
        viewModelScope.launch {
            val result = getWatchListMoviesUseCase()
            Log.i("fragementWAtchlist", result.toString())
            watchlistMovie.postValue(result)
        }
    }
    fun deleteWatchlistMovie(id: String){
        viewModelScope.launch {
            removeWatchlistMovieUseCase(id)
            MainActivity.watchlist.remove(Watchlist(id))
        }
    }
    fun insertWatchlistPopularMovie(watchlistMovieEntity: WatchlistMovieEntity){
        viewModelScope.launch {
            MainActivity.watchlist.add(Watchlist(watchlistMovieEntity.idWatchlist))
            insertWatchlistMovieUseCase(watchlistMovieEntity)
        }
    }

}
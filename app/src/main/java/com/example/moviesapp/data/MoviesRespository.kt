package com.example.moviesapp.data

import com.example.moviesapp.data.database.dao.WatchlistMovieDao
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import com.example.moviesapp.data.network.MoviesService
import com.example.moviesapp.ui.domain.Movie
import com.example.moviesapp.ui.domain.MovieDetail
import com.example.moviesapp.ui.domain.TopReatedMovie
import com.example.moviesapp.ui.domain.toDomain
import javax.inject.Inject

class MoviesRespository @Inject constructor(
    private val api:MoviesService,
    private val watchlistMovieDao: WatchlistMovieDao
) {
    suspend fun getPopularMoviesFromApi():Movie{
        return api.getPopular().toDomain()
    }
    suspend fun getMoviesDetailsFromApi(movieId:String):MovieDetail{
        return api.getMovieInformation(movieId).toDomain()
    }
    suspend fun  getMoviesByNameFromApi(movie:String): Movie{
        return api.getMoviesByName(movie).toDomain()
    }
    suspend fun getTopRatedMoviesFromApi():TopReatedMovie{
        return api.getRated().toDomain()
    }
    suspend fun getWatchlistFromDatabase(): List<WatchlistMovieEntity>{
        return watchlistMovieDao.getAllWatchlistMovies()
    }
    suspend fun insertWatchlistMovieDatabase(watchlistMovieEntity: WatchlistMovieEntity){
        watchlistMovieDao.insertWatchlistMovies(watchlistMovieEntity)
    }
    suspend fun removeWatchlistMovieDatabase(watchlistMovie: String){
        watchlistMovieDao.removeWatchlistMovie(watchlistMovie)
    }

}
package com.example.moviesapp.ui.watchlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import com.example.moviesapp.databinding.FragmentWatchListBinding
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.domain.MovieItem
import com.example.moviesapp.ui.watchlist.recyclerview.WatchlistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WatchListFragment : Fragment() {
    private val viewModel by viewModels<WatchlistViewModel>()
    private var _binding: FragmentWatchListBinding?= null
    private lateinit var adapter: WatchlistAdapter
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        viewModel.watchlistMovie.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })
        adapter = WatchlistAdapter(onItemSelected =  { navigateToDetail(it) },removeWatchlistMovie = {removeWatchlistMovieToDataBase(it)}, addWatchlistMovie = {addWatchlistPopularMovieToDataBase(it)})
        binding.rvWatchList.setHasFixedSize(true)
        binding.rvWatchList.layoutManager = GridLayoutManager(this.context,2)
        binding.rvWatchList.adapter = adapter
        viewModel.allWatchlistMovies()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWatchListBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun navigateToDetail(id:String) {
        val myInformacion = Bundle()
        myInformacion.putString("id",id)
        findNavController().navigate(R.id.detailFragment,myInformacion)
    }
    private fun removeWatchlistMovieToDataBase(id: String){
        viewModel.deleteWatchlistMovie(id)
    }
    private fun addWatchlistPopularMovieToDataBase(watchlistMovieEntity: WatchlistMovieEntity){
        viewModel.insertWatchlistPopularMovie(watchlistMovieEntity)

    }

}
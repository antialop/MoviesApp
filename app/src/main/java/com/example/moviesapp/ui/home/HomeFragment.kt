package com.example.moviesapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.ui.home.recyclerview.PopularMoviesAdapter
import com.example.moviesapp.ui.home.recyclerview.UpcomingMoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PopularMoviesAdapter
    private lateinit var adapterUpcoming: UpcomingMoviesAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        viewModel.popularMovie.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })
        viewModel.upcomingMovie.observe(viewLifecycleOwner, Observer {
            adapterUpcoming.updateList(it)
        })

        adapter = PopularMoviesAdapter(emptyList()) { navigateToDetail(it) }
        adapterUpcoming = UpcomingMoviesAdapter(emptyList()) { navigateToDetail(it) }
        binding.rvPopularMovie.setHasFixedSize(true)
        binding.rvUpcomingMovie.setHasFixedSize(true)
        binding.rvPopularMovie.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvUpcomingMovie.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvPopularMovie.adapter = adapter
        binding.rvUpcomingMovie.adapter = adapterUpcoming
        viewModel.allPopularMovies()
        viewModel.allUpcomingMovies()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun navigateToDetail(id:String) {
        val myInformacion = Bundle()
        myInformacion.putString("id",id)
        findNavController().navigate(R.id.detailFragment,myInformacion)
    }


}
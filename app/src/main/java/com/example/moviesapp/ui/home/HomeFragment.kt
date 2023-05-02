package com.example.moviesapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.GridLayout
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.home.recyclerview.PopularMoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PopularMoviesAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        viewModel.popularMovie.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })

        adapter = PopularMoviesAdapter(emptyList())
        binding.rvPopularMovie.setHasFixedSize(true)
        binding.rvPopularMovie.layoutManager = GridLayoutManager(this.context,2)
        binding.rvPopularMovie.adapter = adapter
        viewModel.allPopularMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }


}
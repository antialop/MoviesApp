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

        adapter = PopularMoviesAdapter(emptyList()) { navigateToDetail(it) }
        binding.rvPopularMovie.setHasFixedSize(true)
        binding.rvPopularMovie.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        //binding.rvPopularMovie.layoutManager = GridLayoutManager(this.context,2)
        binding.rvPopularMovie.adapter = adapter
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
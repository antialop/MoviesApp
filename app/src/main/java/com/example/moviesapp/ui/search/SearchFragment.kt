package com.example.moviesapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.databinding.FragmentSearchBinding
import com.example.moviesapp.ui.home.HomeViewModel
import com.example.moviesapp.ui.home.recyclerview.PopularMoviesAdapter
import com.example.moviesapp.ui.search.recyclerview.SearchMovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val viewModel by viewModels<SearchViewModel>()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SearchMovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    private fun initUI() {
        viewModel.searchMovie.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
            binding.progressBar.isVisible = false
        })
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Busca al pulsar boton
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.progressBar.isVisible = true
                viewModel.movieSearchByName(query.orEmpty())
                return false
            }

            //Busca a medida que vamos escribiendo
            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = SearchMovieAdapter(emptyList()){ navigateToDetail(it) }
        binding.rvMovie.setHasFixedSize(true)
        binding.rvMovie.layoutManager = GridLayoutManager(this.context,2)
        binding.rvMovie.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun navigateToDetail(id:String) {
        val myInformacion = Bundle()
        myInformacion.putString("id",id)
        findNavController().navigate(R.id.detailFragment,myInformacion)
    }

}
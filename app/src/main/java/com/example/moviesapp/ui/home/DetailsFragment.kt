package com.example.moviesapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentDetailsBinding
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.ui.domain.MovieDetail
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.util.Observer


@AndroidEntryPoint
class DetailsFragment : Fragment() {


    private val viewModel by viewModels<DetailsViewModel>()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private var id: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            id = it.getString("id")
        }
        initUI()
    }

    private fun initUI() {

        viewModel.allDetailsMovie(id!!)
        viewModel.detailsMovie.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            createUI(it)
        })
    }

    private fun createUI(movie: MovieDetail) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
            .into(binding.ivMoviePoster)
        binding.tvOriginalTitle.text = movie.original_title
        binding.tvRealeaseDate.text = movie.release_date
        binding.tvRuntime.text = movie.runtime.toString() + " min"
        binding.tvBudget.text = "Budget: " + movie.budget.toString() + " $"
        binding.tvRevenue.text = "Revenue: " + movie.revenue.toString() + " $"
        binding.tvOverview.text = movie.overview

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


}
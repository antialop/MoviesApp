package com.example.moviesapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.moviesapp.R
import com.example.moviesapp.data.database.entities.WatchlistMovieEntity
import com.example.moviesapp.data.network.model.Watchlist
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.ui.home.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object{
        var watchlist: MutableList<Watchlist> = mutableListOf()
    }
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.bottonNavView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)

        binding.bottonNavView.setOnItemSelectedListener {
            when(it.itemId){
                binding.bottonNavView.menu.getItem(0).itemId -> navController.navigate(it.itemId)
                binding.bottonNavView.menu.getItem(1).itemId -> navController.navigate(it.itemId)
                binding.bottonNavView.menu.getItem(2).itemId -> navController.navigate(it.itemId)
                }
            true
            }
            viewModel.getAllWatchlistMovie()
            Log.i("main", watchlist.toString())
        }

}
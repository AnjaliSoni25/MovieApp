package com.example.devrevtest.presentaion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devrevtest.R
import com.example.devrevtest.databinding.ActivityMainBinding
import com.example.devrevtest.presentaion.moviedetails.MovieDetailActivity
import com.example.mylibrary.NetworkSDK
import com.example.mylibrary.Util


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val networkSDK = NetworkSDK(Util.header)
        initViewModel(networkSDK);

        observeData()
        initAdapter()
        initRecyclerView()
        setUpTab();
    }

    private fun initAdapter() {
        movieAdapter = MovieAdapter(this, emptyList()) { selectedMovie ->
            val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
            intent.putExtra("selectedMovie", selectedMovie)
            startActivity(intent)
        }
    }

    private fun observeData() {
        observeTopRatedMovies()
        observePopularMovies()
    }

    private fun initViewModel(networkSDK: NetworkSDK) {
        val viewModelFactory = MovieViewModelFactory(networkSDK)
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }


    private fun observeTopRatedMovies() {
        // Observe latest movies
        viewModel.latestMovies.observe(this, Observer { latestMovies ->
            // Update UI with the latest movies data
            println("Latest Movies: $latestMovies")
            movieAdapter.updateUsers(latestMovies)
        })
    }
    private fun observePopularMovies() {
        // Observe popular movies
        viewModel.popularMovies.observe(this, Observer { popularMovies ->
            // Update UI with the popular movies data
            println("Popular Movies: $popularMovies")
            movieAdapter.updateUsers(popularMovies)

        })
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerView
             recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.adapter = movieAdapter

    }


    private fun setUpTab() {
        viewModel.selectedTabIndex.observe(this) {
            if (it == MovieViewModel.TAB_INDEX_LATEST) {
                binding.tabLatest.setBackgroundResource(R.drawable.raounded_border)
                binding.tabLatest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                binding.tabPopular.setBackgroundColor(getColor(R.color.trans))
                binding.tabPopular.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

            } else if (it == MovieViewModel.TAB_INDEX_POPULAR) {
                binding.tabPopular.setBackgroundResource(R.drawable.raounded_border)
                binding.tabPopular.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                binding.tabLatest.setBackgroundColor(getColor(R.color.trans))
                binding.tabLatest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

            }
        }
    }




}

package com.example.devrevtest.presentaion.moviedetails

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.devrevtest.R
import com.example.devrevtest.databinding.ActivityMovieDetailsBinding
import com.example.mylibrary.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var viewModel:MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_movie_details)
        initViewModel();
        // Retrieve selected movie data
        val movie: Movie? = intent.getParcelableExtra("selectedMovie")

        if (movie != null) {
           binding.movie=movie
            setImage(movie)

        }

    }

    private fun setImage(movie: Movie) {
        val imageUrl = "https://image.tmdb.org/t/p/original${movie.poster_path}"
        Glide.with(this)
            .load(imageUrl)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(40)))
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivMovie)

    }

    private fun initViewModel() {
        viewModel=ViewModelProvider(this)[MovieDetailsViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}
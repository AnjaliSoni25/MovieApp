package com.example.devrevtest.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devrevtest.data.MovieRepository
import com.example.mylibrary.NetworkSDK


class MovieViewModelFactory(private val networkSDK: NetworkSDK) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            val repository = MovieRepository(networkSDK)
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

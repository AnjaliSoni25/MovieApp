package com.example.devrevtest.presentaion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devrevtest.data.MovieRepository
import com.example.mylibrary.Movie
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    companion object {
        const val TAB_INDEX_LATEST = 0
        const val TAB_INDEX_POPULAR = 1
    }

    private val _latestMovies = MutableLiveData<List<Movie>>()
    val latestMovies: LiveData<List<Movie>>
        get() = _latestMovies

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>>
        get() = _popularMovies

    private val _selectedTabIndex = MutableLiveData<Int>()
    val selectedTabIndex: LiveData<Int> = _selectedTabIndex

    init {
        _selectedTabIndex.value = TAB_INDEX_LATEST // Default tab index
        fetchLatestMovies()
    }



    // Method to handle custom tab button clicks
    fun onTabSelected(index: Int) {
        _selectedTabIndex.value = index
        if (index == TAB_INDEX_LATEST) {
            fetchLatestMovies()
        } else if (index == TAB_INDEX_POPULAR) {
            fetchPopularMovies()
        }
    }


    private fun fetchLatestMovies() {
        viewModelScope.launch {
            try {
                val response = repository.getTopRatedMovies("en-US", 1)
                _latestMovies.value = response.results
            } catch (e: Exception) {
                // Handle the error
                e.printStackTrace()
            }
        }
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                val response = repository.getPopularMovies("en-US", 1)
                _popularMovies.value = response.results
            } catch (e: Exception) {
                // Handle the error
                e.printStackTrace()
            }
        }
    }
}

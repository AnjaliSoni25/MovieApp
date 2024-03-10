package com.example.devrevtest.data

import com.example.mylibrary.MovieResponse
import com.example.mylibrary.NetworkSDK

class MovieRepository(private val networkSDK: NetworkSDK) {

    suspend fun getPopularMovies(language: String, page: Int): MovieResponse {
        return networkSDK.getPopularMovies(language, page)
    }

    suspend fun getTopRatedMovies(language: String, page: Int): MovieResponse {
        return networkSDK.getTopRatedMovies(language, page)
    }
}

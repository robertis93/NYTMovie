package com.rob.nytmovie.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rob.nytmovie.MovieRepository
import javax.inject.Inject

class MovieListViewModelFactory @Inject constructor(
    private val repository: MovieRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            MovieListViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
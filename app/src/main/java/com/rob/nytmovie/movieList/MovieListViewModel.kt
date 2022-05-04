package com.rob.nytmovie.movieList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rob.nytmovie.MovieRepository
import com.rob.nytmovie.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(
    private val repository: MovieRepository,
    ) : ViewModel() {

    private val _movieList = MutableSharedFlow<Movie>()
    val movieList: SharedFlow<Movie> = _movieList.asSharedFlow()
    fun getMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movieResult = repository.getMovieResponse()
                withContext(Dispatchers.Main) {
                    _movieList.emit(movieResult)

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                }
            }
        }
    }
}
package com.rob.nytmovie

import com.rob.nytmovie.model.Movie
import com.rob.nytmovie.retrofit.MovieDataFromRemoteSource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    val dataSource: MovieDataFromRemoteSource
    ) {

    suspend fun getMovieResponse(): Movie =
        dataSource.getMovieResponse()
}
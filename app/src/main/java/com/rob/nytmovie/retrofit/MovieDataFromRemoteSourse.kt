package com.rob.nytmovie.retrofit

import com.rob.nytmovie.model.Movie
import javax.inject.Inject

class MovieDataFromRemoteSource @Inject constructor(private val retrofitService: RetrofitServices) {

    suspend fun getMovieResponse(): Movie {
        return retrofitService.getMovieResponse()
    }

}

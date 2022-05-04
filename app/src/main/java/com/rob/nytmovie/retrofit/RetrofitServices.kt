package com.rob.nytmovie.retrofit

import com.rob.nytmovie.model.Movie
import com.rob.nytmovie.utils.id_key
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("movies/v2/reviews/all.json?")
    suspend fun getMovieResponse(
        @Query("query") query: String = "godfather",
        @Query("api-key") appid: String = id_key,
    ): Movie

}
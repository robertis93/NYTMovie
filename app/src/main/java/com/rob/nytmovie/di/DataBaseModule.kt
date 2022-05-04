package com.rob.nytmovie.di

import com.rob.nytmovie.MovieRepository
import com.rob.nytmovie.retrofit.MovieDataFromRemoteSource
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    fun provideRepository(
        movieDataSource: MovieDataFromRemoteSource
    ): MovieRepository {
        return MovieRepository(movieDataSource)
    }
}

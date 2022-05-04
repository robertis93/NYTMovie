package com.rob.nytmovie.di

import com.rob.nytmovie.movieList.MovieListViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, RemoteModule::class, DataBaseModule::class])
@Singleton
interface MovieAppComponent {
    fun getDependencyMovieList(): MovieListViewModelFactory
}


package com.rob.nytmovie

import android.app.Application
import com.rob.nytmovie.di.*

class App : Application() {
    lateinit var component: MovieAppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerMovieAppComponent.builder()
            .remoteModule(RemoteModule(this))
            .applicationModule(ApplicationModule(this))
            .dataBaseModule(DataBaseModule())
            .build()
    }

    fun Application.getComponent(): MovieAppComponent {
        if (this !is App) throw IllegalArgumentException("Для работы метода его надо вызывать у класса App.")
        return component
    }
}

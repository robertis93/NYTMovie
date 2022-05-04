package com.rob.nytmovie.extensions

import android.app.Application
import com.rob.nytmovie.App
import com.rob.nytmovie.di.MovieAppComponent

fun Application.getComponent(): MovieAppComponent {
    if (this !is App) throw IllegalArgumentException("Для работы метода его надо вызывать у класса App.")

    return component
}
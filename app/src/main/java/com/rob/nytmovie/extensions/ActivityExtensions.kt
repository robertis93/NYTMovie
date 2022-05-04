package com.rob.nytmovie.extensions

import android.app.Activity
import com.rob.nytmovie.di.MovieAppComponent

fun Activity.getAppComponent(): MovieAppComponent = application.getComponent()

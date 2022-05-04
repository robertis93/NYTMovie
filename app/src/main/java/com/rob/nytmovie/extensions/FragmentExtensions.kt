package com.rob.nytmovie.extensions

import androidx.fragment.app.Fragment
import com.rob.nytmovie.di.MovieAppComponent

fun Fragment.getAppComponent(): MovieAppComponent = requireActivity().getAppComponent()
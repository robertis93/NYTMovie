package com.rob.nytmovie.di

import android.content.Context
import com.rob.nytmovie.App
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: App) {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    fun provideApp(): App {
        return application
    }
}

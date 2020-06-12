package com.example.nikita_khoryakov_shop

import android.app.Application
import com.example.nikita_khoryakov_shop.di.AppComponent
import com.example.nikita_khoryakov_shop.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}
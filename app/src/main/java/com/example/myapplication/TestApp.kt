package com.example.myapplication

import android.app.Application
import com.example.core.di.ApplicationProvider
import com.example.core.di.IApp
import com.example.myapplication.di.ApplicationComponent

class TestApp : Application(), IApp {

    private lateinit var appComponent: ApplicationProvider

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.init(this)
    }

    override fun getApplicationProvider(): ApplicationProvider {
        return appComponent
    }
}
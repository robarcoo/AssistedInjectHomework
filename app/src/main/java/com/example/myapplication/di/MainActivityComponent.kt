package com.example.myapplication.di

import com.example.core.di.ApplicationProvider
import com.example.myapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    ],
    dependencies = [
        ApplicationProvider::class,
    ]
)
interface MainActivityComponent {

    companion object {
        fun init(applicationProvider: ApplicationProvider): MainActivityComponent {
            return DaggerMainActivityComponent.factory()
                .create(applicationProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            applicationProvider: ApplicationProvider
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}
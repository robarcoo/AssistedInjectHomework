package com.example.myapplication.di



import com.example.core.di.AndroidDependenciesProvider
import com.example.myapplication.TestApp
import com.example.core.di.ApplicationProvider
import com.example.core.di.android.AndroidDependenciesComponent
import dagger.Component

interface ApplicationComponent : ApplicationProvider {

    companion object {

        fun init(app: TestApp) : ApplicationProvider {

            val androidDependenciesProvider = AndroidDependenciesComponent.create(app)

            return DaggerApplicationComponent.factory()
                .create(
                    androidDependenciesProvider
                )
        }

    }


    @Component.Factory
    interface Factory {
        fun create(
            androidDependenciesProvider: AndroidDependenciesProvider
        ): ApplicationComponent
    }

}
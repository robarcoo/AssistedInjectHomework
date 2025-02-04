package com.example.myapplication.di



import com.example.core.di.AndroidDependenciesProvider
import com.example.myapplication.TestApp
import com.example.core.di.ApplicationProvider
import com.example.core.di.android.AndroidDependenciesComponent
import com.example.core.di.android.AndroidDependenciesModule
import dagger.Component


@Component(modules = [AndroidDependenciesModule::class])
interface ApplicationComponent : ApplicationProvider {

    companion object {

        fun init(app: TestApp) : ApplicationProvider {
            val androidDependenciesModule = AndroidDependenciesModule(app)
            return DaggerApplicationComponent.factory()
                .create(androidDependenciesModule)
        }

    }


    @Component.Factory
    interface Factory {
        fun create(
            androidDependenciesModule: AndroidDependenciesModule
        ): ApplicationComponent
    }

}
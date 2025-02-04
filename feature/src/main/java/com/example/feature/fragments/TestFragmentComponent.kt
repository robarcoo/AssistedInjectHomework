package com.example.feature.fragments

import com.example.myapplication.di.ApplicationComponent
import dagger.Component

@Component(dependencies = [ApplicationComponent::class])
interface TestFragmentComponent {
    fun injectTestFragment(testFragment: TestFragment)
}

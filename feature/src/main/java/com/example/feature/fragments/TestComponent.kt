package com.example.feature.fragments

import android.app.Application
import android.content.Context


class TestComponent(context: Context,
    application: Application
    ): TestFragmentComponent {


        override fun injectTestFragment(testFragment: TestFragment) {
        }
    }

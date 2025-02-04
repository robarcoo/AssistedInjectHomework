package com.example.feature.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.core.di.AndroidDependenciesProvider
import com.example.feature.viewmodel.TestViewModel
import com.example.feature.viewmodel.lazyViewModel
import javax.inject.Inject

class TestFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: TestViewModel.Factory

    private val viewModel: TestViewModel by lazyViewModel { stateHandle ->
        viewModelFactory.create(stateHandle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val componentDependencies = (context.applicationContext as AndroidDependenciesProvider)
        val testComponent = TestComponent(componentDependencies.provideContext(), componentDependencies.provideApplication())
        testComponent.injectTestFragment(this)
    }
}
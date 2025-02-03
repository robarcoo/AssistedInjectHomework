package com.example.feature.fragments

import androidx.fragment.app.Fragment
import com.example.feature.viewmodel.TestViewModel
import com.example.feature.viewmodel.lazyViewModel
import javax.inject.Inject

class TestFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: TestViewModel.Factory

    private val viewModel: TestViewModel by lazyViewModel { stateHandle ->
        viewModelFactory.create(stateHandle)
    }
}
package com.example.feature.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.assisted.Assisted

class TestViewModel @AssistedInject constructor(
    @Assisted
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): TestViewModel
    }

    companion object {
        fun providesFactory(
            assistedFactory: Factory,
            savedStateHandle: SavedStateHandle
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(savedStateHandle) as T
            }
        }
    }
}
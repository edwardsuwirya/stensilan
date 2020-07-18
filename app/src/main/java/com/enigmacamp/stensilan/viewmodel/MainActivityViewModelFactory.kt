package com.enigmacamp.stensilan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.stensilan.repository.StensilRepository

class MainActivityViewModelFactory(private val stensilRepository: StensilRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(stensilRepository) as T
    }
}
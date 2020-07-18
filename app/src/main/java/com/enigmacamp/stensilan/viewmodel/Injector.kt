package com.enigmacamp.stensilan.viewmodel

import com.enigmacamp.stensilan.repository.DummyStensilDataStore
import com.enigmacamp.stensilan.repository.StensilRepository

object Injector {
    fun provideMainActivityModelFactory(): MainActivityViewModelFactory {
        val stensilDummyDataStore = DummyStensilDataStore()
        val stensilRepository = StensilRepository(stensilDummyDataStore)
        val factory = MainActivityViewModelFactory(stensilRepository)
        return factory
    }
}
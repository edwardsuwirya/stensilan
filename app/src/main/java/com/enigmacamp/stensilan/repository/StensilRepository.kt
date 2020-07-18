package com.enigmacamp.stensilan.repository

import com.enigmacamp.stensilan.model.Stensil

class StensilRepository(private val localDataStore: StensilDataStore) {
    fun getStensilByTitle(title: String): MutableList<Stensil>? {
        return localDataStore.getAllStensilByTitle(title)
    }
}
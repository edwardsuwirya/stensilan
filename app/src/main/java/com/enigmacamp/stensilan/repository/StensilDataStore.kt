package com.enigmacamp.stensilan.repository

import com.enigmacamp.stensilan.model.Stensil

interface StensilDataStore {
    fun getAllStensilByTitle(title: String): MutableList<Stensil>
}

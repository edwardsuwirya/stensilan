package com.enigmacamp.stensilan.repository

import com.enigmacamp.stensilan.model.Stensil

class DummyStensilDataStore : StensilDataStore {
    override fun getAllStensilByTitle(title: String): MutableList<Stensil> {
        val list = arrayListOf<Stensil>()
        list.add(Stensil("My Love", "...", "Edo", "Romance"))
        list.add(Stensil("Sinful", "...", "Edo", "Romance"))
        return list
    }
}
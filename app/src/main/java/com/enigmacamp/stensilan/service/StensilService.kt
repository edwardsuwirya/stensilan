package com.enigmacamp.stensilan.service

import com.enigmacamp.stensilan.model.Stensil

class StensilService {
    fun getAllStensilByTitle(title: String): ArrayList<Stensil> {
        val list = arrayListOf<Stensil>()
        list.add(Stensil("My Love", "...", "Edo", "Romance"))
        list.add(Stensil("Sinful", "...", "Edo", "Romance"))
        return list
    }
}
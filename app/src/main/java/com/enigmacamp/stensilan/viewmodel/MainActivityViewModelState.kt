package com.enigmacamp.stensilan.viewmodel

import com.enigmacamp.stensilan.model.Stensil
import java.lang.Exception

data class MainActivityViewModelState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: List<Stensil>? = null
) {

}
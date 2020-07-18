package com.enigmacamp.stensilan.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enigmacamp.stensilan.model.Stensil
import com.enigmacamp.stensilan.repository.StensilRepository

class MainActivityViewModel(val stensilReposistory: StensilRepository) : ViewModel() {
    val keyword = MutableLiveData<String>()
    val stensilList = MutableLiveData<List<Stensil>>()

    fun getAllStensilByTitle(title: String): MutableLiveData<List<Stensil>> {
        val myHandler = Handler()
        myHandler.postDelayed({
            stensilList.value = stensilReposistory.getStensilByTitle(title)
        }, 5000)
        return stensilList
    }

    fun setKeyword(title: String) {
        keyword.value = title
    }

}
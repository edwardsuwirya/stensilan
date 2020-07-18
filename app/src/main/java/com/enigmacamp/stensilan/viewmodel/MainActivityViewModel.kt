package com.enigmacamp.stensilan.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enigmacamp.stensilan.repository.StensilRepository

class MainActivityViewModel(val stensilReposistory: StensilRepository) : ViewModel() {
    val keyword = MutableLiveData<String>()

    val stensilState = MutableLiveData<MainActivityViewModelState>()

    fun getAllStensilByTitle(title: String): MutableLiveData<MainActivityViewModelState> {
        val myHandler = Handler()
        myHandler.postDelayed({
            val data = stensilReposistory.getStensilByTitle(title)
            stensilState.value =
                stensilState.value?.copy(loading = false, error = null, data = data)
        }, 3000)
        return stensilState
    }

    fun setKeyword(title: String) {
        keyword.value = title
        stensilState.value = MainActivityViewModelState(loading = true)
    }

}
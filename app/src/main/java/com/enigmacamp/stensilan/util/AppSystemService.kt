package com.enigmacamp.stensilan.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object AppSystemService {

    fun hideKeyboard(context: Context, view: View) {
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            view!!.windowToken, 0
        )
    }
}

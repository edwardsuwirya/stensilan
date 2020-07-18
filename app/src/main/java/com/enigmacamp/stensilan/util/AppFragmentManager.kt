package com.enigmacamp.stensilan.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.enigmacamp.stensilan.R

class AppFragmentManager(val resource:Int, val manager: FragmentManager) {

    fun addFragment(fragment: Fragment) {
        val fragmentTransaction = manager.beginTransaction()
        fragmentTransaction.add(resource, fragment).commit()
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = manager.beginTransaction()
        fragmentTransaction.replace(resource, fragment).commit()
    }

    fun deleteFragment(fragment: Fragment) {
        val fragmentTransaction = manager.beginTransaction()
        fragmentTransaction.remove(fragment).commit()
    }
}
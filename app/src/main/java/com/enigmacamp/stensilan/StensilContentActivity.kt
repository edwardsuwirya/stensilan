package com.enigmacamp.stensilan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.enigmacamp.stensilan.model.Stensil
import com.google.android.material.snackbar.Snackbar

class StensilContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stensil_content)
        val list: Stensil = intent.getParcelableExtra(StensilListFragment.INTENT_LIST_KEY)

        val actionBar = supportActionBar
        actionBar!!.title = list.title
//        val parentLayout: View = findViewById(android.R.id.content);
//        val snack: Snackbar = Snackbar.make(parentLayout, "Text label", Snackbar.LENGTH_LONG)
//            .setAction("Action") {
//                // Responds to click on the action
//            }
//
//        val closeButton: Button = findViewById(R.id.close_button)
//        closeButton.setOnClickListener {
//            snack.show()
//        }

    }
}
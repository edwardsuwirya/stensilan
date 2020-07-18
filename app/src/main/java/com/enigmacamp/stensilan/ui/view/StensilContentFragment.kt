package com.enigmacamp.stensilan.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enigmacamp.stensilan.R


class StensilContentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stensil_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = StensilContentFragment()
    }
}
package com.enigmacamp.stensilan.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.enigmacamp.stensilan.R
import com.enigmacamp.stensilan.model.Stensil
import com.enigmacamp.stensilan.util.AppFragmentManager
import com.enigmacamp.stensilan.util.ProgressBarModal

class StensilContentActivity : AppCompatActivity() {
    private lateinit var fragmentManager: AppFragmentManager
    private lateinit var stensilContentFragment: StensilContentFragment
    private lateinit var progressBarModal: AlertDialog

    private val TAG = StensilContentActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stensil_content)

        fragmentManager = AppFragmentManager(R.id.stensil_content_fragment, supportFragmentManager)
        stensilContentFragment = StensilContentFragment.newInstance()

        progressBarModal = ProgressBarModal.progressBar(this)
        progressBarModal.show()


        val list: Stensil = intent.getParcelableExtra(StensilListFragment.INTENT_LIST_KEY)

        val actionBar = supportActionBar
        actionBar!!.title = list.title


    }
}
package com.enigmacamp.stensilan.ui.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.enigmacamp.stensilan.R
import com.enigmacamp.stensilan.model.Stensil
import com.enigmacamp.stensilan.repository.DummyStensilDataStore
import com.enigmacamp.stensilan.repository.StensilRepository
import com.enigmacamp.stensilan.util.AppFragmentManager
import com.enigmacamp.stensilan.util.AppSystemService
import com.enigmacamp.stensilan.util.ProgressBarModal
import com.enigmacamp.stensilan.viewmodel.Injector
import com.enigmacamp.stensilan.viewmodel.MainActivityViewModel
import com.enigmacamp.stensilan.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var welcomeFragment: WelcomeFragment
    private lateinit var stensilListFragment: StensilListFragment
//    private lateinit var fragmentManager: AppFragmentManager

    private lateinit var progressBarModal: AlertDialog

    private lateinit var mainActivityViewModel: MainActivityViewModel

    private var keyword: String = ""

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    fun initializeUi() {
        progressBarModal = ProgressBarModal.progressBar(this)
        welcomeFragment = WelcomeFragment.newInstance()
        val factory = Injector.provideMainActivityModelFactory()

        mainActivityViewModel =
            ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)
        mainActivityViewModel.keyword.observe(this, Observer {
//            Log.d(TAG,it)
            keyword = it
            mainActivityViewModel.getAllStensilByTitle(it)
        })
        mainActivityViewModel.stensilState.observe(this, Observer {
//            Log.d(TAG,keyword)
            if (it.loading) {
                progressBarModal.show()
            } else {
                onCallListFragment(keyword, it.data!!)
                progressBarModal.dismiss()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchStensil = menu.findItem(R.id.app_bar_search)
        val searchView = searchStensil.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query.isNullOrEmpty()) {
                    return false
                } else {
                    searchView.onActionViewCollapsed()
                    mainActivityViewModel.setKeyword(query)
                    return true
                }
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true
    }

    fun onCallListFragment(keyword: String, list: List<Stensil>) {
        stensilListFragment = StensilListFragment.newInstance()
        val args = Bundle();
        Log.d(TAG, keyword)
        args.putString("keyword", keyword);
        args.putParcelableArray(
            "list", list.toTypedArray()
        );

        stensilListFragment.arguments = args
        Navigation.findNavController(this, R.id.myNavHostFragment)
            .navigate(R.id.action_welcomeFragment_to_stensilListFragment, args)
    }
}
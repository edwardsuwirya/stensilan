package com.enigmacamp.stensilan.ui.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentManager
import com.enigmacamp.stensilan.R
import com.enigmacamp.stensilan.service.StensilService

class MainActivity : AppCompatActivity() {
    private lateinit var welcomeFragment: WelcomeFragment
    private lateinit var stensilListFragment: StensilListFragment
    private lateinit var fragmentManager: FragmentManager
    private lateinit var stensilService: StensilService

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeFragment =
            WelcomeFragment.newInstance()
        stensilListFragment =
            StensilListFragment.newInstance()

        stensilService = StensilService()

        fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_fragment, welcomeFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchStensil = menu.findItem(R.id.app_bar_search)
        val searchView = searchStensil.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, query)
                if (query.isNullOrEmpty()) {
                    return false
                } else {
                    hideKeyboard()
                    searchView.onActionViewCollapsed()
                    val args = Bundle();

                    args.putString("keyword", query);
                    args.putParcelableArrayList("list", stensilService.getAllStensilByTitle(query));
                    stensilListFragment.arguments = args
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.home_fragment, stensilListFragment).commit()
                    return true
                }
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        return true
    }

    fun hideKeyboard() {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            currentFocus?.windowToken,
            InputMethodManager.SHOW_FORCED
        )
    }
}
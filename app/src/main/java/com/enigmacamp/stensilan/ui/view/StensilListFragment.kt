package com.enigmacamp.stensilan.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigmacamp.stensilan.R
import com.enigmacamp.stensilan.ui.adapter.StensilListRecyclerViewAdapter
import com.enigmacamp.stensilan.model.Stensil
import com.enigmacamp.stensilan.util.AppFragmentManager


class StensilListFragment : Fragment(),
    StensilListRecyclerViewAdapter.ListSelectionRecyclerViewClickListener {
    private lateinit var keywordTextView: TextView
    private lateinit var listsRecyclerView: RecyclerView

    private lateinit var fragmentManager: AppFragmentManager

    private val TAG = StensilListFragment::class.java.simpleName

    companion object {
        const val INTENT_LIST_KEY = "list"

        fun newInstance(): StensilListFragment {
            return StensilListFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager = AppFragmentManager(R.id.home_fragment, activity!!.supportFragmentManager)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                fragmentManager.replaceFragment(WelcomeFragment.newInstance())
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stensil_list, container, false)
        val args = getArguments();
        val keyword = args?.getString("keyword", "");
        val list = args?.getParcelableArrayList<Stensil>("list") as ArrayList<Stensil>
        Log.d(TAG, keyword)
        keywordTextView = view.findViewById(R.id.keyword_textview)
        keywordTextView.text = getString(R.string.search_keyword, keyword)

        listsRecyclerView = view.findViewById(R.id.list_recyclerview)
        listsRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        listsRecyclerView.adapter = StensilListRecyclerViewAdapter(list, this)

        return view
    }


    private fun showListDetail(stensil: Stensil) {
        val listDetailIntent = Intent(activity, StensilContentActivity::class.java)
        listDetailIntent.putExtra(INTENT_LIST_KEY, stensil)
        activity!!.startActivity(listDetailIntent)
    }

    override fun listItemClicked(list: Stensil) {
        showListDetail(list)
    }
}
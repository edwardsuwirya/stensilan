package com.enigmacamp.stensilan.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.enigmacamp.stensilan.R
import com.enigmacamp.stensilan.model.Stensil
import com.enigmacamp.stensilan.ui.adapter.StensilListRecyclerViewAdapter
import com.enigmacamp.stensilan.util.AppFragmentManager
import kotlinx.android.synthetic.main.fragment_stensil_list.*


class StensilListFragment : Fragment(),
    StensilListRecyclerViewAdapter.ListSelectionRecyclerViewClickListener {
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
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = getArguments();
        val keyword = args?.getString("keyword", "");
        val list = args?.getParcelableArrayList<Stensil>("list") as ArrayList<Stensil>
        Log.d(TAG, keyword)
        keyword_textview.text = getString(R.string.search_keyword, keyword)

        list_recyclerview.layoutManager = LinearLayoutManager(view.context)
        list_recyclerview.adapter = StensilListRecyclerViewAdapter(list, this)
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
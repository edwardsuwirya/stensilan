package com.enigmacamp.stensilan.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.enigmacamp.stensilan.R
import com.enigmacamp.stensilan.model.Stensil
import com.enigmacamp.stensilan.ui.adapter.StensilListRecyclerViewAdapter
import com.enigmacamp.stensilan.util.AppFragmentManager
import kotlinx.android.synthetic.main.fragment_stensil_list.*


class StensilListFragment : Fragment(),
    StensilListRecyclerViewAdapter.ListSelectionRecyclerViewClickListener {

    private val TAG = StensilListFragment::class.java.simpleName

    companion object {
        const val INTENT_LIST_KEY = "list"

        fun newInstance(): StensilListFragment {
            return StensilListFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(requireActivity(), R.id.myNavHostFragment)
                    .popBackStack()
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
        val list = args?.getParcelableArray("list") as Array<Stensil>
        Log.d(TAG, keyword)
        keyword_textview.text = getString(R.string.search_keyword, keyword)

        list_recyclerview.layoutManager = LinearLayoutManager(view.context)
        list_recyclerview.adapter = StensilListRecyclerViewAdapter(list.toList(), this)
    }


    private fun showListDetail(stensil: Stensil) {
        val listDetailIntent = Intent(activity, StensilContentActivity::class.java)
        listDetailIntent.putExtra(INTENT_LIST_KEY, stensil)
        requireActivity().startActivity(listDetailIntent)
    }

    override fun listItemClicked(list: Stensil) {
        showListDetail(list)
    }
}
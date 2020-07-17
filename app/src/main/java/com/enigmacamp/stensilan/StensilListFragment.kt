package com.enigmacamp.stensilan

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigmacamp.stensilan.adapter.StensilListRecyclerViewAdapter
import com.enigmacamp.stensilan.model.Stensil
import kotlinx.android.synthetic.main.fragment_stensil_list.*

private val TAG = StensilListFragment::class.java.simpleName

class StensilListFragment : Fragment() {
    private lateinit var keywordTextView: TextView
    private lateinit var listsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stensil_list, container, false)
        val args = getArguments();
        val keyword = args?.getString("keyword", "");
        val list = args?.getParcelableArrayList<Stensil>("list") as ArrayList<Stensil>
        Log.d(TAG, list.toString())
        keywordTextView = view.findViewById(R.id.keyword_textview)
        keywordTextView.text = getString(R.string.search_keyword, keyword)

        listsRecyclerView = view.findViewById(R.id.list_recyclerview)
        listsRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        listsRecyclerView.adapter = StensilListRecyclerViewAdapter(list)

        return view
    }

    companion object {
        fun newInstance(): StensilListFragment {
            return StensilListFragment()
        }
    }
}
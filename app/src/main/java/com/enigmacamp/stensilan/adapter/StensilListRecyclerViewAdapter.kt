package com.enigmacamp.stensilan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enigmacamp.stensilan.R
import com.enigmacamp.stensilan.model.Stensil

class StensilListRecyclerViewAdapter(private val lists: ArrayList<Stensil>) :
    RecyclerView.Adapter<StensilListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StensilListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.stensil_list_view_holder,
            parent,
            false
        )
        return StensilListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: StensilListViewHolder, position: Int) {
        holder.category.text = lists.get(position).category
        holder.title.text = lists.get(position).title
    }
}
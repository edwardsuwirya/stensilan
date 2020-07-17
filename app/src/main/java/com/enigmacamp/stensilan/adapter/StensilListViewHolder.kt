package com.enigmacamp.stensilan.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enigmacamp.stensilan.R

class StensilListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById(R.id.title_textView) as TextView
    val category = itemView.findViewById(R.id.category_textView) as TextView
}
package com.app.gadiadmin.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.gadiadmin.R

class FeedRecycler(private val context: Context, private val list: List<FeedData>):RecyclerView.Adapter<FeedRecycler.Viewholder>() {
    class Viewholder(itemview:View) : RecyclerView.ViewHolder(itemview) {
        val nme=itemview.findViewById<TextView>(R.id.name)
        val mail=itemview.findViewById<TextView>(R.id.email)
        val msg=itemview.findViewById<TextView>(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view=LayoutInflater.from(context).inflate(R.layout.feed,parent,false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.nme.text=list[position].name
        holder.mail.text=list[position].email
        holder.msg.text=list[position].message
    }
}
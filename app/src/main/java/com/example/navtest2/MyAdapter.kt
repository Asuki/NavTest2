package com.example.navtest2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context: Context, private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<MyAdapter.MyListViewHolder>() {
    class MyListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = itemView.findViewById(R.id.textViewItem)
        var clickTap: FrameLayout = itemView.findViewById(R.id.clickTap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.my_list_item, parent, false)
        return MyListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        val data = dataSet[position]
        holder.textView?.text = data
        holder.clickTap.setOnClickListener(View.OnClickListener { view ->
            Toast.makeText(context, "${data} tószt", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.secondFragment)
        })
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
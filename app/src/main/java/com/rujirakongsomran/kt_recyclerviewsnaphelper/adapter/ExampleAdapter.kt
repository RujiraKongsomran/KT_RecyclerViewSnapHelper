package com.rujirakongsomran.kt_recyclerviewsnaphelper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rujirakongsomran.kt_recyclerviewsnaphelper.R
import com.rujirakongsomran.kt_recyclerviewsnaphelper.model.ExampleItem


class ExampleAdapter(private val exampleList: List<ExampleItem>) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.example_item,
                parent, false
            )
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.tv_1.text = currentItem.text1
        holder.tv_2.text = currentItem.text2

    }

    override fun getItemCount() = exampleList.size

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val tv_1: TextView = itemView.findViewById(R.id.tv_1)
        val tv_2: TextView = itemView.findViewById(R.id.tv_2)
    }
}
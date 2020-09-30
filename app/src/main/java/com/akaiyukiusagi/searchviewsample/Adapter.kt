package com.akaiyukiusagi.searchviewsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val dataset: List<String>):
    RecyclerView.Adapter<ViewHolder>() {

    // MyViewHolder.kt と my_text_view.xml の内容を元にViewHolderを作成する
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false)
        return ViewHolder(view)
    }

    // ViewHolder一行ごとに描画する内容を記載
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataset[position]
    }

    override fun getItemCount() = dataset.size // 行数決定 Dataset なのか Item なのか ViewHolder なのかはっきりしてくれ

}

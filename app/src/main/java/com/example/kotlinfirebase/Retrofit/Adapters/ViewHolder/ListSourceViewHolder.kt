package com.example.kotlinfirebase.Retrofit.Adapters.ViewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirebase.R
import com.example.kotlinfirebase.Retrofit.Interfaces.ItemClickListener

class ListSourceViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
    private lateinit var itemClickListener: ItemClickListener

    val tvTitle:TextView = itemView.findViewById(R.id.source_new_name)
  init {
      itemView.setOnClickListener(this)
  }

        fun setItemClickListener(itemClickListener: ItemClickListener){
            this.itemClickListener=itemClickListener
        }
    override fun onClick(v: View?) {
       itemClickListener.onClick(v!!,adapterPosition)
    }

}
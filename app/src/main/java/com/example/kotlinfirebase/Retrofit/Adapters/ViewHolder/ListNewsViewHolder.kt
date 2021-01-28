package com.example.kotlinfirebase.Retrofit.Adapters.ViewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirebase.R
import com.example.kotlinfirebase.Retrofit.Interfaces.ItemClickListener
import com.github.curioustechizen.ago.RelativeTimeTextView
import de.hdodenhof.circleimageview.CircleImageView

class ListNewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
    private lateinit var itemClickListener: ItemClickListener

    val article_title:TextView = itemView.findViewById(R.id.article_title)
    val article_time: RelativeTimeTextView =itemView.findViewById(R.id.article_time)
    val article_image:CircleImageView = itemView.findViewById(R.id.article_image)



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
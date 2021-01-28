package com.example.kotlinfirebase.Retrofit.Adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirebase.R
import com.example.kotlinfirebase.Retrofit.Adapters.ViewHolder.ListSourceViewHolder
import com.example.kotlinfirebase.Retrofit.Interfaces.ItemClickListener
import com.example.kotlinfirebase.Retrofit.Models.WebSiteNews
import com.example.kotlinfirebase.ui.ListNews


class ListSourceAdapter(private val context: Context, private val webSiteNews: WebSiteNews):RecyclerView.Adapter<ListSourceViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSourceViewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val itemView=inflater.inflate(R.layout.source_news_layout, parent, false)
        return ListSourceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListSourceViewHolder, position: Int) {
      val item = webSiteNews.sources!![position]
       holder!!.tvTitle.text=item.name
        holder.setItemClickListener(object : ItemClickListener {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(context, ListNews::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                }
                intent.putExtra("source", webSiteNews.sources!![position].id)
                context.startActivity(intent)

            }
        })
    }

    override fun getItemCount(): Int {
       return webSiteNews.sources!!.size
    }
}
package com.example.kotlinfirebase.Retrofit.Adapters

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirebase.Common.ISO8601Parser
import com.example.kotlinfirebase.R
import com.example.kotlinfirebase.Retrofit.Adapters.ViewHolder.ListNewsViewHolder
import com.example.kotlinfirebase.Retrofit.Interfaces.ItemClickListener
import com.example.kotlinfirebase.Retrofit.Models.NewsBBC.Article
import com.squareup.picasso.Picasso
import java.text.ParseException
import java.util.*
import kotlin.collections.ArrayList


class ListNewsAdapter(private val context: Context,val articleList:ArrayList<Article>):RecyclerView.Adapter<ListNewsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
        val inflater=LayoutInflater.from(parent!!.context)
        val itemView = inflater.inflate(R.layout.news_layout,parent, false)
        return ListNewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
            //Load image
       Picasso.get()
           .load(articleList
               .get(position).urlToImage).into(holder.article_image)
        if (articleList[position].title!!.length>65){
            holder.article_title.text=articleList[position].title!!.substring(0,65)+"..."
        }
        else{
            holder.article_title.text=articleList[position].title!!
        }
        if (articleList[position].publishedAt !=null){
            var date: Date?=null
            try {
                date= ISO8601Parser.parse(articleList[position].publishedAt)

            }catch (e:ParseException){
                e.printStackTrace()
                Log.i("ERROR",e.toString())
            }
            holder.article_time!!.setReferenceTime(date!!.time)
        }
        holder.setItemClickListener(object :ItemClickListener{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(context,"News selecter${articleList[position].title}",Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun getItemCount(): Int {
     return  articleList.size
    }
}
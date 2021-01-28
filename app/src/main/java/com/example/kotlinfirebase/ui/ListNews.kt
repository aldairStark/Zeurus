package com.example.kotlinfirebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.kotlinfirebase.Common.Common
import com.example.kotlinfirebase.R
import com.example.kotlinfirebase.Retrofit.Adapters.ListNewsAdapter
import com.example.kotlinfirebase.Retrofit.Interfaces.NewsService
import com.example.kotlinfirebase.Retrofit.Models.NewsBBC.Article
import com.example.kotlinfirebase.Retrofit.Models.NewsBBC.NewsBBC
import com.flaviofaria.kenburnsview.KenBurnsView
import com.github.florent37.diagonallayout.DiagonalLayout
import com.squareup.picasso.Picasso
import dmax.dialog.SpotsDialog
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListNews : AppCompatActivity() {
    var source=""
    var webHotUrl: String? = ""
   lateinit var dialog:android.app.AlertDialog
   lateinit var mServices:NewsService
   lateinit var adapter:ListNewsAdapter
   private lateinit var swipe_To_refresh: SwipeRefreshLayout
   lateinit var diagonalLayout:DiagonalLayout
    lateinit var list_news: RecyclerView
    lateinit var top_image:KenBurnsView
    lateinit var top_titles:TextView
    lateinit var top_author:TextView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)



        Paper.init(this)
        mServices= Common.newsService
        dialog = SpotsDialog.Builder().setContext(this).build()
        swipe_To_refresh=findViewById(R.id.swipe_refresh_list_news)
        diagonalLayout=findViewById(R.id.diagonalLayout)
        list_news=findViewById(R.id.list_news)
        top_image = findViewById(R.id.top_image)
        top_titles = findViewById(R.id.top_Title)
        top_author=findViewById(R.id.top_author)

        swipe_To_refresh.setOnRefreshListener {
            loadNews(source,true)
        }
        diagonalLayout.setOnClickListener{

        }
        list_news.setHasFixedSize(true)
        list_news.layoutManager= LinearLayoutManager(this)

        if (intent !=null)
        {
            source= intent.getStringExtra("source").toString()
            if (!source.isEmpty())
                loadNews(source,false)
        }
    }

    private fun loadNews(source: String, isRefreshed: Boolean) {
            if(isRefreshed)
            {
                dialog.show()
                mServices.getNewsFromSources(Common.getNewsAPI(source!!))
                    .enqueue(object :Callback<NewsBBC>{
                        override fun onResponse(call: Call<NewsBBC>, response: Response<NewsBBC>) {
                            dialog.dismiss()
                            Picasso.get()
                                .load(response.body()!!.articles!![0].urlToImage)
                                .into(top_image)

                            top_titles.text = response.body()!!.articles!![0].title
                            top_author.text=response.body()!!.articles!![0].author
                            webHotUrl = response.body()!!.articles!![0].url


                            val removeFirstItem:ArrayList<Article> = response!!.body()!!.articles as ArrayList<Article>
                            removeFirstItem.removeAt(0)
                            adapter= ListNewsAdapter(baseContext,removeFirstItem!!)
                            adapter.notifyDataSetChanged()
                            list_news.adapter=adapter
                            // Because we get first item to hot new, so we need remove it
                                swipe_To_refresh.isRefreshing=false
                        }

                        override fun onFailure(call: Call<NewsBBC>, t: Throwable) {
                            Toast.makeText(baseContext,"Failiure",Toast.LENGTH_SHORT).show()

                            dialog.dismiss()
                        }

                    })
            }
        else{
                dialog.show()
                mServices.getNewsFromSources(Common.getNewsAPI(source!!))
                    .enqueue(object :Callback<NewsBBC>{
                        override fun onResponse(call: Call<NewsBBC>, response: Response<NewsBBC>) {
                            dialog.dismiss()
                            Picasso.get()
                                .load(response.body()!!.articles!![0].urlToImage)
                                .into(top_image)

                            top_titles.text = response!!.body()!!.articles!![0].title
                            top_author.text=response!!.body()!!.articles!![0].author
                            webHotUrl = response!!.body()!!.articles!![0].url


                            val removeFirstItem:ArrayList<Article> = response!!.body()!!.articles as ArrayList<Article>
                            removeFirstItem!!.removeAt(0)
                            adapter= ListNewsAdapter(baseContext,removeFirstItem!!)
                            adapter.notifyDataSetChanged()
                            list_news.adapter=adapter
                            // Because we get first item to hot new, so we need remove it
                            swipe_To_refresh.isRefreshing=false
                        }

                        override fun onFailure(call: Call<NewsBBC>, t: Throwable) {
                            Toast.makeText(baseContext,"Failiure", Toast.LENGTH_SHORT).show()

                            dialog.dismiss()
                        }

                    })
            }
    }
}
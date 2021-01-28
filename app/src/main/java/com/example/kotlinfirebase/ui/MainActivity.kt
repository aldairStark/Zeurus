package com.example.kotlinfirebase.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kotlinfirebase.Common.Common
import com.example.kotlinfirebase.Common.Constants
import com.example.kotlinfirebase.KotlinResources.Functions
import com.example.kotlinfirebase.R
import com.example.kotlinfirebase.Retrofit.Interfaces.NewsService
import com.example.kotlinfirebase.Retrofit.Adapters.ListSourceAdapter
import com.example.kotlinfirebase.Retrofit.Models.WebSiteNews
import com.example.kotlinfirebase.Volley.PeticionNoticias
import com.google.gson.Gson
import dmax.dialog.SpotsDialog
import io.paperdb.Paper
import org.json.JSONException
import retrofit2.Call


class MainActivity : AppCompatActivity() {
 lateinit var a:Functions


    lateinit var layoutManager: LinearLayoutManager
    lateinit var mServices:NewsService
    lateinit var adapter: ListSourceAdapter
    private  lateinit var dialog: android.app.AlertDialog


    private lateinit var button: Button
    private lateinit var swipe_To_refresh:SwipeRefreshLayout
    lateinit var recycler_view_sources: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        a
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.botton)
        recycler_view_sources=findViewById(R.id.recyclerView_SourceNews)


        Paper.init(this)
        mServices=Common.newsService
        swipe_To_refresh=findViewById(R.id.swipe_refresh_news)

        swipe_To_refresh.setOnRefreshListener {  
            loadToWebsiteSource(true)
        }
        recycler_view_sources.setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this)
        recycler_view_sources.layoutManager= layoutManager

      dialog = SpotsDialog.Builder().setContext(this).build()

    loadToWebsiteSource(false)





        button.setOnClickListener {
            val intent = Intent(this, Elsihay::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }
    }

    private fun loadToWebsiteSource(isRefresh: Boolean) {
            if (!isRefresh){
                val cache = Paper.book().read<String>("cache")
                if (cache !=null && !cache.isBlank() && cache != "null"){
                    val webSiteNews= Gson().fromJson<WebSiteNews>(cache,WebSiteNews::class.java)
                    adapter= ListSourceAdapter(baseContext,webSiteNews)
                    adapter.notifyDataSetChanged()
                    recycler_view_sources.adapter=adapter
                }
                else{
                    dialog.show()

                    mServices.sources.enqueue(object :retrofit2.Callback<WebSiteNews>{
                        override fun onResponse(
                            call: Call<WebSiteNews>,
                            response: retrofit2.Response<WebSiteNews>) {

                                    adapter= ListSourceAdapter(baseContext,response.body()!!)
                            adapter.notifyDataSetChanged()
                            recycler_view_sources.adapter=adapter

                            Paper.book().write("cache",Gson().toJson(response.body()!!))
                            dialog.dismiss()
                        }

                        override fun onFailure(call: Call<WebSiteNews>, t: Throwable) {
                            Toast.makeText(baseContext,"Failiure",Toast.LENGTH_SHORT).show()

                            dialog.dismiss()
                        }

                    })
                }
            }
        else{
            swipe_To_refresh.isRefreshing=true

                mServices.sources.enqueue(object :retrofit2.Callback<WebSiteNews>{
                    override fun onResponse(
                        call: Call<WebSiteNews>,
                        response: retrofit2.Response<WebSiteNews>) {

                        adapter= ListSourceAdapter(baseContext,response.body()!!)
                        adapter.notifyDataSetChanged()
                        recycler_view_sources.adapter=adapter

                        Paper.book().write("cache",Gson().toJson(response.body()!!))
                        swipe_To_refresh.isRefreshing=false
                    }

                    override fun onFailure(call: Call<WebSiteNews>, t: Throwable) {
                        Toast.makeText(baseContext,"Failiure",Toast.LENGTH_SHORT).show()

                        swipe_To_refresh.isRefreshing=false
                    }

                })
            }
    }

    fun VolleyNewsResponse(){
       PeticionNoticias(this).peticion()
    }

    private fun Context(){
        val TAGeRROR:String="ERROR"
        val TAGsUSSESFUL:String="SUSSES"
        fun peticion(){
            val coladepeticiones= Volley.newRequestQueue(this)
            val peticionesJSON = StringRequest(Request.Method.GET, Constants.NEWSBASE_URL,
                    Response.Listener{ response ->
                        try {
                            for(i in response)
                            Log.d("$TAGsUSSESFUL", response.toString())

                        }catch (e: JSONException){
                            e.printStackTrace()
                        }
                    },
                    Response.ErrorListener { error ->
                        Log.d("$TAGeRROR",error.toString())
                    }
            )
            coladepeticiones.add(peticionesJSON)
        }
        peticion()
    }



}
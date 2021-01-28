package com.example.kotlinfirebase.Retrofit.Interfaces

import com.example.kotlinfirebase.Common.Common.API_KEY
import com.example.kotlinfirebase.Retrofit.Models.NewsBBC.NewsBBC
import com.example.kotlinfirebase.Retrofit.Models.Source
import com.example.kotlinfirebase.Retrofit.Models.WebSiteNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
import java.lang.StringBuilder

interface NewsService {
   /* @GET("v2/sources")
    fun getSources():Call<Website>*/

   @get:GET ("v2/sources?language=en&apiKey=f77dce2f7570417b884895e03a2ddca3")
    val sources: Call<WebSiteNews>

    @GET
    fun getNewsFromSources(@Url url:String):Call<NewsBBC>



}
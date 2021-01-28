package com.example.kotlinfirebase.Common

import com.example.kotlinfirebase.Retrofit.Interfaces.NISTservices
import com.example.kotlinfirebase.Retrofit.Interfaces.NewsService
import com.example.kotlinfirebase.Retrofit.Remote.RetrofitCli
import java.lang.StringBuilder

object Common {

    val BASE_URL="https://newsapi.org/"
    val NIST_BASEURL=""
    val API_KEY="f77dce2f7570417b884895e03a2ddca3"
    val URL_PARAM_LANGUAJE="es"

    val newsService:NewsService
    get() = RetrofitCli.RetrofitClients(BASE_URL).create(NewsService::class.java)

    val NISTservices:NISTservices
    get() = RetrofitCli.RetrofitNIST(NIST_BASEURL).create(NISTservices::class.java)

    fun getNewsAPI(source: String):String{
        val apiUrl= StringBuilder("https://newsapi.org/v2/top-headlines?sources=")
            .append(source)
            .append("&apiKey=")
            .append(API_KEY)
            .toString()
        return apiUrl
    }
}
package com.example.kotlinfirebase.Retrofit.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCli {
  var retrofit:Retrofit? = null
    var retrofitNist:Retrofit?=null

    fun RetrofitClients(BASE_URL:String):Retrofit{

        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        return retrofit!!
    }
    fun RetrofitNIST(NIST_BASEURL:String):Retrofit {
        if (retrofitNist == null) {
            retrofitNist = Retrofit.Builder()
                .baseUrl(NIST_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitNist!!
    }
}
package com.example.kotlinfirebase.Retrofit.Remote


import android.util.Log
import com.example.kotlinfirebase.Common.Common
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClients {

fun getRetrofitNews():Retrofit{
    var retofit= Retrofit.Builder()
        .baseUrl(Common.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    Log.i("PRINT",retofit.toString())
return retofit
}


}
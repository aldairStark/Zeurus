package com.example.kotlinfirebase.Retrofit.Interfaces

import com.example.kotlinfirebase.NistApi.Dataset
import retrofit2.Call
import retrofit2.http.GET

interface NISTservices {

    @get:GET("")
    val title: Call<Dataset>
}
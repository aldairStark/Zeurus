package com.example.kotlinfirebase.Retrofit.Models.NewsMX

data class NewsMx(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
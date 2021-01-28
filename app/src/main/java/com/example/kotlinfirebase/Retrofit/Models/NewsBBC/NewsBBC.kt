package com.example.kotlinfirebase.Retrofit.Models.NewsBBC

import com.example.kotlinfirebase.Retrofit.Models.NewsBBC.Article

data class NewsBBC(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
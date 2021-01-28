package com.example.kotlinfirebase.Retrofit.Models.NewsBBC

import com.example.kotlinfirebase.Retrofit.Models.NewsBBC.Source

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)
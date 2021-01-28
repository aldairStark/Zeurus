package com.example.kotlinfirebase.NistApi

data class Distribution(
    val accessURL: String,
    val describedBy: String,
    val describedByType: String,
    val description: String,
    val downloadURL: String,
    val format: String,
    val mediaType: String,
    val title: String
)
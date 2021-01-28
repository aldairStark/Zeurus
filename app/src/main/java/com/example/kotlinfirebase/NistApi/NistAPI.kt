package com.example.kotlinfirebase.NistApi

import com.example.kotlinfirebase.NistApi.Dataset

data class NistAPI(
    val context: String,
    val type: String,
    val conformsTo: String,
    val dataset: List<Dataset>,
    val describedBy: String
)
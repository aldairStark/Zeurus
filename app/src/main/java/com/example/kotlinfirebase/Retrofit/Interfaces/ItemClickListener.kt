package com.example.kotlinfirebase.Retrofit.Interfaces

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.text.ParsePosition

interface ItemClickListener {
    fun onClick(view:View, position: Int)
}
package com.example.kotlinfirebase

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.kotlinfirebase.ui.Elsihay
import com.example.kotlinfirebase.ui.MainActivity

class Lottie_splashScreen : AppCompatActivity() {
private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie_splash_screen)
        supportActionBar?.hide()

        handler= Handler()
        handler.postDelayed({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
            finish()
        },3000)

    }

}
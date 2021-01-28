package com.example.kotlinfirebase.KotlinResources

import android.util.Log
import java.util.*

class Functions {

    private fun Function03() {
        // named arguments
        fun ferdinand(name: String, lastname: String, age: Int, yesterday: Date) {

        }
        ferdinand("jose", "nava", 25, Date())
        ferdinand(lastname = "25", age = 25, yesterday = Date(), name = "jose")
    }

    private fun Function04() {
        //Single-Expression functions
        fun sumar(param1: Int, param2: Int) = param1 + param2

    }

    private fun Function05() {
        //variable number of arguments (varags)
        fun sum(vararg numbers: Int) = numbers
        val rest = sum(1, 2, 12, 1, 2, 1, 3, 4, 6, 4, 6, 4, 6)
        rest

    }

    private fun Function06() {
        //Extencions Function

    }

    private fun Function07() {
     val a= object : welcome{
         override fun welcome() {
Log.i("Permutar","Hola que hace")         }
     }
     
    }

    private fun Function08()  {



    }
    interface welcome{
        fun welcome()
    }
}
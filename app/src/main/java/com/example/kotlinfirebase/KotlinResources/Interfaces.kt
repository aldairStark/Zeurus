package com.example.kotlinfirebase

import android.util.Log
import java.lang.reflect.Array.get

interface Interfaces {
    private var anomymusInterface: Any?
        get() = null
        set(value) = TODO()


    private fun Showcase(){
        anomymusInterface = object : Interface1{
            override fun abstractMethod() {

            }
        }
        (anomymusInterface as Interface1).abstractMethod()
        (anomymusInterface as Interface1).methidDefault()

    }
    private fun ShowCase2(){
        val aoii = object :Interface2{
            override val property1: Int
                get() = 10

        }
        aoii.property1
        aoii.propertyString
    }

    interface Interface1{
        fun abstractMethod()
        fun methidDefault(){
            
        }
    }
    interface Interface2 {
        val property1:Int
        var propertyString:String
            get()="By Value"
            set(value){this.propertyString = value}
        fun hola(){
            Log.i("PROPERTY"," IS WORKEN $propertyString  $property1")
        }
    }

}
interface Icars{
    var age:Int
    fun Hello()
}


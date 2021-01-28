package com.example.kotlinfirebase.Common

import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

object ISO8601Parser{
    fun parse(params:String):Date{
        var input=params
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
        if (input.endsWith("Z"))
            input = input.substring(0,input.length-1)+"GMT-00:00"
        else
        {
            val  inset=6
            val s0 = input.subSequence(0,input.length - inset)
            val s1=input.substring(input.length - inset,input.length)

            input = StringBuilder(s0).append("GMT").append(s1).toString()
        }
        return df.parse(input)
    }
    fun toStrong(date: Date):String{
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
        val tz = TimeZone.getTimeZone("UTC")
        df.timeZone=tz

        val output =df.format(date)

        var inset0 = 9
        var inset1=6

        var s0 = output.substring(0,output.length-inset0)
        var s1= output.subSequence(output.length-inset1,output.length)
        var result:String = s0 + s1
        result = result.replace("UTC".toRegex(), "+00:00")

        return result
    }

}
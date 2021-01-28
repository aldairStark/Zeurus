package com.example.kotlinfirebase.Volley

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.kotlinfirebase.Common.Constants
import org.json.JSONException
import org.json.JSONObject

class PeticionNoticias(context: Context) {
        var context=context
    val TAGeRROR:String="ERROR"
    val TAGsUSSESFUL:String="SUSSES"
    fun peticion(){
        val coladepeticiones=Volley.newRequestQueue(context)
        val peticionesJSON = JsonObjectRequest(Request.Method.GET,Constants.NEWSBASE_URL,null,
                    Response.Listener<JSONObject> { response ->
                        try {
                            Log.i("$TAGsUSSESFUL", response.toString())

                        }catch (e:JSONException){
                            e.printStackTrace()
                        }
                    },
                Response.ErrorListener { error ->
                    Log.d("$TAGeRROR",error.toString())
                }
                )
        coladepeticiones.add(peticionesJSON)
    }
}
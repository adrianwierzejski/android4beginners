package com.daftmobile.a4bhomework5

import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    // /api/pokemon/:number
    @GET("/api/pokemon/{number}/peek")
    fun getPokenmonInfo(@Path ("number")number: String): Call <ResponseBody>
}


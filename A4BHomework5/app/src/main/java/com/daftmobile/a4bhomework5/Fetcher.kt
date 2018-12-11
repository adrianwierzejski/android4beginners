package com.daftmobile.a4bhomework5

import android.provider.Settings
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import com.google.gson.Gson


class Fetcher{

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://switter.app.daftmobile.com/")
            .build()

    private val Api = retrofit.create(Api::class.java)

    fun fetch(index: String,onSuccess: (PokemonItem) -> Unit, onError: (String) -> Unit) {
        val call = Api.getPokenmonInfo(index)
        call.enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                onError(t.message?: "No message")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val gson:Gson= Gson()
                    val item = gson.fromJson(response.body()?.charStream(), PokemonItem::class.java)
                    onSuccess(item)
                } else
                    onError("Serwer zwrócił: ${response.code()}")
            }
        })

    }
}

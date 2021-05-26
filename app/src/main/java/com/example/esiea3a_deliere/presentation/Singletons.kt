package com.example.esiea3a_deliere.presentation

import com.example.esiea3a_deliere.MemeApplication.Companion.context
import com.example.esiea3a_deliere.presentation.api.MemesApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object{
        var cache : Cache = Cache(File(context?.cacheDir, "response"), 10*1024*1024)
        val okhttpClient : OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()


        val memesApi: MemesApi = Retrofit.Builder()
            .baseUrl("https://api.imgflip.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
            .create(MemesApi::class.java)
    }
}
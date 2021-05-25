package com.example.esiea3a_deliere.presentation.api

import retrofit2.Call
import retrofit2.http.GET

interface MemesApi {
    @GET("get_memes")
    fun getMemesList(): Call<DataResponse>
}
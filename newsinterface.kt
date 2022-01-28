package com.example.application

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("top-headlines")
    fun Fetchnews(@Query("country") country:String,@Query("apiKey")apiKey:String,@Query("category")category:String):Call<NewsClass>
}

package com.example.application

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Newsservice {
    private val retrofit =Retrofit.Builder()
        .baseUrl(Constants.base_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val newsInterface:NewsInterface= retrofit.create(NewsInterface::class.java)
}

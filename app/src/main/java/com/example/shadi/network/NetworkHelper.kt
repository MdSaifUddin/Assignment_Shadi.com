package com.example.shadi.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkHelper {
    var INSTANCE: Apis? = null

    fun getInstance(): Apis{
        if(INSTANCE == null){

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()

            INSTANCE = Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Apis::class.java)
        }
        return INSTANCE!!
    }
}
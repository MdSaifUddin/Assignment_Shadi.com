package com.example.shadi.network

import com.example.shadi.model.NetworkResponse
import com.example.shadi.model.ProfilesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET("api")
    suspend fun getProfiles(@Query("results") result: Int): Response<ProfilesModel>

}
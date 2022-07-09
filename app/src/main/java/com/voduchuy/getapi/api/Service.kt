package com.voduchuy.getapi.api

import com.voduchuy.getapi.model.UsersItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("users")
    fun getUser(): Call<List<UsersItem>>
    @GET("users")
    fun getSearch(@Query("name") name:String): Call<List<UsersItem>>
}
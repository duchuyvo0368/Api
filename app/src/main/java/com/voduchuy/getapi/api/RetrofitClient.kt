package com.voduchuy.getapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private lateinit var retrofit: Retrofit
        fun getClient(baseUrl: String): Retrofit {
            retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }
    }

}
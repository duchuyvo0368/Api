package com.voduchuy.getapi.api

class ApiUtils {
    companion object{
        private var BASE_URL:String="https://jsonplaceholder.typicode.com/"
        fun getDataService(): Service {
            return RetrofitClient.getClient(BASE_URL).create(Service::class.java)
        }
    }
}
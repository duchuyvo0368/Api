package com.voduchuy.getapi.model

import com.google.gson.annotations.Expose

data class UsersItem(

    val id: Int,

    val name: String,

    val username: String,

    val email: String,


){

    fun getImage()="https://www.w3schools.com/w3css/img_lights.jpg"
}
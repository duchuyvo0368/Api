package com.voduchuy.getapi.model

import com.google.gson.annotations.Expose

data class UsersItem(

    val id: Int,

    val name: String,

    val username: String,
//
//    val email: String,
    val mobile:String,
    val workEmail:String,
    val personalEmail:String,
    val company:String,
    val jobTitle:String


){

    fun getImage()="https://www.w3schools.com/w3css/img_lights.jpg"
}
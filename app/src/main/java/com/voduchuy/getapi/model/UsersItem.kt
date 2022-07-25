package com.voduchuy.getapi.model

import com.google.gson.annotations.Expose

data class UsersItem(

    val id: Int,

    val name: String,

//
//    val email: String,
    val mobile:String,
    val email:String,
    val title:String


){

    fun getImage()="https://www.w3schools.com/w3css/img_lights.jpg"
//    fun getSong():String="http://vnso-zn-23-tf-mp3-s1-zmp3.zmdcdn.me/a6c1d7a6cde124bf7df0/1509899083994918457?authen=exp=1658222809~acl=/a6c1d7a6cde124bf7df0/*~hmac=e702d956c3c561aba0cbb8c0181624dc"
}
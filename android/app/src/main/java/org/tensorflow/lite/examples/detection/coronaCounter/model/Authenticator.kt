package com.example.coronacounter.model

object Authenticator{

    fun isNewId(id:String,userdatabase:Map<String,String>):Boolean {
        return !userdatabase.containsKey(id)
    }

}
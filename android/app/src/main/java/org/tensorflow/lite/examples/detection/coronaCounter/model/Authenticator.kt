package com.example.coronacounter.model

import android.util.Log

object Authenticator{

    fun checkVal(user:User,userdatabase:Map<String,String>):Boolean {
        val id = user.id
        var password = user.password
        if (!userdatabase.containsKey(id) ){
            Log.d("auth",user.password.toString()+"failed")
            return false
        }
        else{
            return userdatabase[id] == password
        }
    }

    fun isNewId(id:String,userdatabase:Map<String,String>):Boolean {
        return !userdatabase.containsKey(id)
    }
}
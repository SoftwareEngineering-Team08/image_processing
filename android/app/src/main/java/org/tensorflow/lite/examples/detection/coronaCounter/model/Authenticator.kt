package com.example.coronacounter.model

import android.util.Log
import org.tensorflow.lite.examples.detection.coronaCounter.model.UserData

object Authenticator{

//    fun checkVal(user:User,userdatabase:Map<String,String>):Boolean {
//        val id = user.id
//        var password = user.password
//        if (!userdatabase.containsKey(id) ){
//            Log.d("auth",user.password.toString()+"failed")
//            return false
//        }
//        else{
//            return userdatabase[id] == password
//        }
//    }

    fun checkVal(userInput: UserData, DBuserInfo: UserData):Boolean {
        val id = DBuserInfo.id  // db에 존재하는 id
        var password = DBuserInfo.pw    // db에 존재하는 pw
        if (!userInput.id.equals(id) ){
            Log.d("auth",userInput.pw.toString()+"failed")
            return false
        }
        else{
            return userInput.pw.equals(password)
        }
    }


    fun isNewId(id:String,userdatabase:Map<String,String>):Boolean {
        return !userdatabase.containsKey(id)
    }
}
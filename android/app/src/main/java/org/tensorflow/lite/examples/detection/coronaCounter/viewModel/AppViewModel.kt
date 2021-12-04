package com.example.coronacounter.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.coronacounter.model.Authenticator
import com.example.coronacounter.model.Datas
import com.example.coronacounter.model.Shop
import com.example.coronacounter.model.User
import org.tensorflow.lite.examples.detection.coronaCounter.api.Api
import org.tensorflow.lite.examples.detection.coronaCounter.model.UserData

class AppViewModel:ViewModel(){
    private lateinit var _user : User
    val user: User get() = _user

    val auth = Authenticator
    val userdata  = Datas.userdatabase
    val shopdata  =  Datas.shops

//    fun userLogin(user:User) : Boolean {
//        if (auth.checkVal(user,userdata)){
//            _user = user
//            return true
//        }
//        else{
//            return false
//        }
//    }

    suspend fun signup(user: UserData, retIn: Api): Boolean {
        val DBAccess = retIn.authentication(user)
        if (DBAccess.isSuccessful){ // http code
            val DBuserInfo = DBAccess.body()!!
            if (auth.checkVal(user,DBuserInfo)){
                _user = User(DBuserInfo.id!!,DBuserInfo.pw!!)
                return true
            }
            else    // password error
                return false
        } else{     // network error
            Log.d("AppViewModel","network error")
            return false
        }
    }

    fun isNewUser(id:String) : Boolean {
        return auth.isNewId(id,userdata)
    }

    fun addUser(user:User){

        userdata[user.id] = user.password
    }

    fun getShops(user:User) : List<Shop> {
        return shopdata[user.id] ?: listOf<Shop>()
    }

}

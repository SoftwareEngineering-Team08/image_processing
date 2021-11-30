package com.example.coronacounter.viewModel

import android.provider.ContactsContract
import androidx.lifecycle.ViewModel
import com.example.coronacounter.model.Authenticator
import com.example.coronacounter.model.Datas
import com.example.coronacounter.model.Shop
import com.example.coronacounter.model.User

class AppViewModel:ViewModel() {
    private lateinit var _user : User
    val user: User get() = _user

    val auth = Authenticator
    val userdata  = Datas.userdatabase
    val shopdata  =  Datas.shops
    fun userLogin(user:User) : Boolean {
        if (auth.checkVal(user,userdata)){
            _user = user
            return true
        }
        else{
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
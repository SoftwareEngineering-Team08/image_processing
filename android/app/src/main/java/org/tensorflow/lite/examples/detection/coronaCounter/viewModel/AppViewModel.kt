package com.example.coronacounter.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.coronacounter.model.Authenticator
import com.example.coronacounter.model.Datas
import com.example.coronacounter.model.Shop
import com.example.coronacounter.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.tensorflow.lite.examples.detection.coronaCounter.api.Api
import org.tensorflow.lite.examples.detection.coronaCounter.api.RetrofitInstance

class AppViewModel:ViewModel(){
    private lateinit var _user : User
    val user: User get() = _user

    val auth = Authenticator
    val userdata  = Datas.userdatabase
    val shopdata  =  Datas.shops

    private val loginApi = RetrofitInstance.instance.create(Api::class.java)

    suspend fun signin(user: User): Boolean {
        return withContext(Dispatchers.IO){
            val DBAccess = loginApi.authentication(user)
            if (DBAccess.isSuccessful){ // http code
                val DBuserInfo = DBAccess.body()!!
                if (DBuserInfo.id.equals("id invalid")){
                    false
                } else if (DBuserInfo.pw.equals("password wrong")){
                    false
                } else {
                    _user = DBuserInfo
                    user.oname = DBuserInfo.oname
                    true
                }
            } else{     // network error
                Log.d("AppViewModel","network error")
                false
            }
        }
    }

    suspend fun getDistance(rname: String): Integer{
        return withContext(Dispatchers.IO){
            val DBAccess = loginApi.getDistance(rname)
            if (DBAccess.isSuccessful){
                DBAccess.body()!!
            }
            DBAccess.body()!!
        }
    }

    fun isNewUser(id:String) : Boolean {
        return auth.isNewId(id,userdata)
    }

    fun addUser(user:User){

        userdata[user.id!!] = user.pw!!
    }

    fun getShops(user:User) : List<Shop> {
        return shopdata[user.id] ?: listOf<Shop>()
    }

}

package com.example.coronacounter.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronacounter.model.Authenticator
import com.example.coronacounter.model.Datas
import com.example.coronacounter.model.Shop
import com.example.coronacounter.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.tensorflow.lite.examples.detection.coronaCounter.api.Api
import org.tensorflow.lite.examples.detection.coronaCounter.api.RetrofitInstance
private const val TAG = "AppViewModel"

class AppViewModel:ViewModel(){
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _shops = MutableLiveData<List<Shop>>()
    val shops: LiveData<List<Shop>> get() = _shops

    val auth = Authenticator
    val userdata  = Datas.userdatabase
    val shopdata  =  Datas.shops

    private val loginApi = RetrofitInstance.instance.create(Api::class.java)


    // 유저를 세팅하고, 결과를 알려주는 함수
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
                    _user.postValue(DBuserInfo)
                    true
                }
            } else{     // network error
                Log.d(TAG,"network error")
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

    suspend fun isNewUser(id:String) : Boolean {
        return withContext(Dispatchers.IO){
            val DBAccess = loginApi.isIdValid(id)
            if (DBAccess.isSuccessful){ // http code
                val isValid = DBAccess.body()!!
                isValid
            } else{     // network error
                Log.d(TAG,"network error")
                false
            }
        }
    }

    fun addUser(user:User){

        userdata[user.id!!] = user.pw!!
    }

    //샵 리스트를 업데이트 하는 함수
    suspend fun fetchShops() {
        Log.d(TAG,"fetch shops")
        withContext(Dispatchers.IO) {
            //TODO 데이터베이스에 접속
            //아래 다 지우고 작성
            delay(100)
            _shops.postValue(shopdata[user.value?.id] ?: listOf<Shop>())
        }
    }


}

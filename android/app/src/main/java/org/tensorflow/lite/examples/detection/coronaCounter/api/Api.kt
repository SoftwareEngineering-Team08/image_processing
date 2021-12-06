package org.tensorflow.lite.examples.detection.coronaCounter.api

import com.example.coronacounter.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @Headers("Content-Type:application/json")
    @POST("login")
    suspend fun authentication(@Body user: User)
    : Response<User>

    @Headers("Content-Type:application/json")
    @POST("distance-stage")
    suspend fun getDistance(@Body rname: String)
    : Response<Integer>
}

object RetrofitInstance {
    // 안드로이드는 클라이언트 ip가 다름.
//    val BASE_URL: String = "http://10.0.2.2:8080/"
    val BASE_URL: String = "http://3.13.129.81:8080/"

    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    val instance: Retrofit by lazy {
        val gson: Gson = GsonBuilder().setLenient().create()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
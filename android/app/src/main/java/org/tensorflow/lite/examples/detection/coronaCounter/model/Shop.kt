package com.example.coronacounter.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Shop(
    @SerializedName("sid")
    var sid:String?,

    @SerializedName("sname")
    var shopName:String?,

    @SerializedName("rname")
    var location:String?,

    @SerializedName("maxPeople")
    var maximumPeople:Integer?,

    @SerializedName("limitPeople")
    var limitPeople:Integer?,

    @SerializedName("businessType")
    var businessType:BusinessType?
) :Serializable
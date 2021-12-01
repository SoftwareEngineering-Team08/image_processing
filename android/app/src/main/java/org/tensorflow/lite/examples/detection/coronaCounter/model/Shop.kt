package com.example.coronacounter.model

import java.io.Serializable

data class Shop(var id:String, var shopName:String, var location:String, var maximumPeople:Int,var limitPeople:Int, var businessType:BusinessType) :Serializable {
}
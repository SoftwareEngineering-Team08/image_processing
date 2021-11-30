package com.example.coronacounter.model


// need priority update here
enum class BusinessType(val priority:Int) {
    RESTAURANT(3),ACADEMY(2),GYM(4),BAR(5),HOTEL(1)
}
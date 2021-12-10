package com.example.coronacounter.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("onum")
    var onum: Integer?,

    @SerializedName("id")
    var id: String?,

    @SerializedName("pw")
    var pw: String?,

    @SerializedName("oname")
    var oname: String?

) : Serializable
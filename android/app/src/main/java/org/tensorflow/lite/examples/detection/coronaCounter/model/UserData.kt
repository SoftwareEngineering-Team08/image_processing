package org.tensorflow.lite.examples.detection.coronaCounter.model

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserData(
    @SerializedName("onum")
    var onum: Int?,

    @SerializedName("id")
    var id: String?,

    @SerializedName("pw")
    var pw: String?,

    @SerializedName("oname")
    var oname: String?
) : Serializable
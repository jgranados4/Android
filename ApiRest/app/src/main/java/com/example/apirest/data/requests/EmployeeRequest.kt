package com.example.apirest.data.requests

import com.google.gson.annotations.SerializedName
data class EmployeeRequest(
//    @SerializedName("id")
//    var id: Int,

    @SerializedName("nombre")
    var nombre: String,

    @SerializedName("apellido")
    var apellido: String,

    @SerializedName("email")
    var email: String
)

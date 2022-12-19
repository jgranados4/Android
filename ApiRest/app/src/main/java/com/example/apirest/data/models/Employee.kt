package com.example.apirest.data.models

import com.google.gson.annotations.SerializedName
data class Employee(
    @SerializedName("id")
    var id: Int,

    @SerializedName("nombre")
    var nombre: String,

    @SerializedName("apellido")
    var apellido: String,

    @SerializedName("email")
    var email: String
)

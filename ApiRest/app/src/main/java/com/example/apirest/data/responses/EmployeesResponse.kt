package com.example.apirest.data.responses

import com.example.apirest.data.models.Employee
import com.google.gson.annotations.SerializedName

data class EmployeesResponse(
    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("usuario")
    var usuario: List<Employee>
)

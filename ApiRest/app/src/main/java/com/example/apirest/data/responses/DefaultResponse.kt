package com.example.apirest.data.responses

import com.google.gson.annotations.SerializedName
data class DefaultResponse(
    val status_code: Int,
    val error: Boolean,
    val message: String
)


package com.example.apirest.data.services

import com.example.apirest.data.requests.EmployeeRequest
import com.example.apirest.data.responses.DefaultResponse
import com.example.apirest.data.responses.EmployeesResponse
import retrofit2.Call
import retrofit2.http.*
interface ApiService {
    @Headers("Accept:application/json", "Content-Type:application/json")
    @GET("/")
    fun getListEmployees(): Call<EmployeesResponse>
    @POST("/add_dato")
    fun addEmployee(@Body request: EmployeeRequest): Call<DefaultResponse>
    @PUT("/update_dato/{id}")
    fun updateEmployee(@Path("id") id: Int, @Body request: EmployeeRequest): Call<DefaultResponse>
    @DELETE("/delete_dato/{emp_id}")
    fun deleteEmployee(@Path("emp_id") emp_id: Int): Call<DefaultResponse>
}

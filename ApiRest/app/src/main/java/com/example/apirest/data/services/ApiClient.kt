package com.example.apirest.data.services

import android.content.Context
import com.example.apirest.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class ApiClient {
    private lateinit var apiService: ApiService
    fun getApiService(context: Context): ApiService {
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build()
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService
    }
    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}

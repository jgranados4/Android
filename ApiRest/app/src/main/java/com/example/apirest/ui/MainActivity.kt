package com.example.apirest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apirest.R
import com.example.apirest.data.adapters.RecyclerAdapter
import com.example.apirest.data.models.Employee
import com.example.apirest.data.responses.EmployeesResponse
import com.example.apirest.data.services.ApiClient
import com.example.apirest.util.MyMessages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var apiCliente: ApiClient
    var datalist = ArrayList<Employee>()
    lateinit var recyclerview: RecyclerView
    lateinit var adpater: RecyclerAdapter

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.IO).launch {
            cargarDatos()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiCliente = ApiClient()
        recyclerview = findViewById(R.id.RecyclerIni)


    }

    private suspend fun cargarDatos() {
        apiCliente.getApiService(this).getListEmployees()
            .enqueue(object : Callback<EmployeesResponse> {
                override fun onResponse(
                    call: Call<EmployeesResponse>,
                    response: Response<EmployeesResponse>
                ) {
                    val liseEmploy = response.body()?.usuario
                    if (liseEmploy != null) {
                        recyclerview.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = RecyclerAdapter(liseEmploy)
                        }
                    } else {
                        MyMessages.toast(applicationContext, "no existen registro")
                    }
                }

                override fun onFailure(call: Call<EmployeesResponse>, t: Throwable) {
                    MyMessages.toast(applicationContext, t.toString())
                }

            })


    }

    fun menuHome(item: MenuItem) {
        when (item.getItemId()) {
            R.id.add -> {
                Toast.makeText(this, "Nuevo Registro", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ventana2::class.java).apply {
                    putExtra("nombre", "juan")
                }
                startActivity(intent)

            }
            R.id.exit -> {
                this.onBackPressed();
            }
        }
    }
}
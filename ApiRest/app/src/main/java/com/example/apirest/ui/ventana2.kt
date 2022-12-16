package com.example.apirest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.apirest.R
import com.example.apirest.data.requests.EmployeeRequest
import com.example.apirest.data.responses.DefaultResponse
import com.example.apirest.data.services.ApiClient
import com.example.apirest.util.MyMessages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ventana2 : AppCompatActivity() {
    lateinit var TxtNombre:EditText
    lateinit var  TxtApellido:EditText
    lateinit var TxtEmail:EditText
    lateinit var  BtnAgregar:Button
    lateinit var BtnRegresar:Button
    lateinit var apiClient:ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana2)
        apiClient= ApiClient()
        TxtNombre=findViewById(R.id.NombreU)
        TxtApellido=findViewById(R.id.ApellidoU)
        TxtEmail=findViewById(R.id.EmailU)
        BtnAgregar=findViewById(R.id.AgregarD)
        BtnRegresar=findViewById(R.id.RegresarD)

        BtnAgregar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                AddCliente()
            }
        }

    }
    private suspend fun AddCliente(){
        val name=TxtNombre.text.toString().trim()
        val lastname=TxtApellido.text.toString().trim()
        val  Email=TxtEmail.text.toString().trim()
        if(name.isEmpty()){
            withContext(Dispatchers.Main){
                TxtNombre.error="Ingrese el nombre"
                TxtNombre.requestFocus()
            }
            return
        }
        if(lastname.isEmpty()){
            withContext(Dispatchers.Main){
                TxtApellido.error="Ingrese el apellido"
                TxtApellido.requestFocus()
            }
            return
        }
        if(Email.isEmpty()){
            withContext(Dispatchers.Main){
                TxtEmail.error="Ingrese el Email"
                TxtEmail.requestFocus()
            }
            return
        }
        //ApiRest
        apiClient.getApiService(this).addEmployee(EmployeeRequest(name,lastname,Email))
            .enqueue(object: Callback<DefaultResponse> {
                override fun onResponse(
                    call: Call<DefaultResponse>,
                    response: Response<DefaultResponse>
                ) {
                    val defaultResponse=response.body()
                    if ( defaultResponse!= null) {
                        if (response.code()==200 && defaultResponse.error==false){
                            MyMessages.toast(applicationContext,defaultResponse.message)
                            return
                        }
                    }else{
                        MyMessages.toast(applicationContext,"Error")
                    }
                }

                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    MyMessages.toast(applicationContext,t.toString())
                }

            })
    }
    fun regregar(view: View){
        finish()
    }
}
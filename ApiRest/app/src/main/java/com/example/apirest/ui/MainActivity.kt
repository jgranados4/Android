package com.example.apirest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.apirest.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun menuHome (item: MenuItem) {
        when(item.getItemId()) {
            R.id.add -> {
                Toast.makeText(this,"Nuevo Registro",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ventana2::class.java).apply {
                    putExtra("nombre","juan")
                }
                startActivity(intent)

            }
            R.id.exit-> {
                this.onBackPressed();
            }
        }
    }
}
package com.example.apirest.data.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.TextView
import com.example.apirest.R
import com.example.apirest.data.models.Employee
import com.example.apirest.ui.ventana2
import com.example.apirest.util.MyMessages
open class MyViewHolderEmployee(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var name: TextView
    lateinit var apellido : TextView
    lateinit var email: TextView
    lateinit var prefix: TextView
    fun bind(employee: Employee) {
        prefix = itemView.findViewById(R.id.prefix)
        name = itemView.findViewById(R.id.name)
        apellido=itemView.findViewById(R.id.apellido)
        email = itemView.findViewById(R.id.email)

        name.text = employee?.name
        prefix.text = employee.id.toString()
        apellido.text=employee.apellido
        email.text = employee?.email


        itemView.setOnClickListener {
            MyMessages.toast(itemView.context, employee?.name.toString())
            val intent = Intent(itemView.context, ventana2::class.java)
            intent.putExtra("per_id", name.id)
            itemView.context.startActivity(intent)
        }
    }


}


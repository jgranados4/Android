package com.example.apirest.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apirest.R
import com.example.apirest.data.models.Employee
class RecyclerAdapter(val employeeList: List<Employee>) : RecyclerView.Adapter<MyViewHolderEmployee>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderEmployee {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view  = layoutInflater.inflate(R.layout.row_employees, parent, false)
        val viewHolder = MyViewHolderEmployee(view)
        return viewHolder
    }
    override fun getItemCount(): Int {
        return employeeList?.size!!
    }
    override fun onBindViewHolder(holder: MyViewHolderEmployee, position: Int) {
        employeeList?.get(position)?.let { holder.bind(it) }
    }
}

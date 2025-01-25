package com.practicum.recyclerviewapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practicum.recyclerviewapp.databinding.EmployeeItemBinding

class EmployeeAdapter: RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>() {
    private val employeeList = ArrayList<Employee>()//список в который добавляем элементы (например с бд или с помощью кнопки)

    class EmployeeHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = EmployeeItemBinding.bind(item)
        fun bind(employee: Employee) {//заполнение шаблона view (employee_item)
            binding.img.setImageResource(employee.imageId)
            binding.tvName.text = employee.name
        }
    }

    //создает шаблон (который можно заполнить) и объект класса EmployeeHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)//создает view (employee_item) в памяти, можно заполнить шаблон
        return EmployeeHolder(view)
    }

    //запускается после onCreateViewHolder
    //необходио запустить bind, чтобы появилась возможность заполнять шаблон
    //position - позиция элемента в нарисованном списке (которую нужно создать)
    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    //размер массива - количество запусков функции onCreateViewHolder и onBindViewHolder
    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun addEmployee(employee: Employee) {
        employeeList.add(employee)
        notifyItemInserted(employeeList.size - 1)//список был обновлен, необходимо отрисовать его заново
    }
    
    //также можно реализовать и др (удаление обновление)
    fun addAll(list: List<Employee>) {
        employeeList.clear()
        employeeList.addAll(list)
        notifyItemInserted(employeeList.size - 1)//при удалении будет другое
    }
}
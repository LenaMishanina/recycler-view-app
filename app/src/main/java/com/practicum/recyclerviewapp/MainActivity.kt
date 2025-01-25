package com.practicum.recyclerviewapp

import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicum.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = EmployeeAdapter()
    private val imageIdList = listOf(
        R.drawable.employee1,
        R.drawable.employee2,
        R.drawable.employee3,
        R.drawable.employee4,
        R.drawable.employee5
    )
    private var employeeIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)//после 3 элементов в строке переходит на следующую строку
            rcView.adapter = adapter

            btnAdd.setOnClickListener {
                if (employeeIndex > 4) employeeIndex = 0
                adapter.addEmployee(Employee(imageIdList[employeeIndex], "Employee $employeeIndex"))
                employeeIndex++
            }
        }
    }
}
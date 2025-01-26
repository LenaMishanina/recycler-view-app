package com.practicum.recyclerviewapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.practicum.recyclerviewapp.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private val imageIdList = listOf(
        R.drawable.employee1,
        R.drawable.employee2,
        R.drawable.employee3,
        R.drawable.employee4,
        R.drawable.employee5
    )
    private var imageIndex = 0
    private var imageId = R.drawable.employee1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        btnNextImage.setOnClickListener {
            imageIndex++
            if (imageIndex > imageIdList.size - 1) imageIndex = 0
            imageId = imageIdList[imageIndex]
            imageView.setImageResource(imageId)
        }

        btnDone.setOnClickListener {
            val employee = Employee(imageId, edTitle.text.toString(), edDesc.text.toString())
            val intent = Intent(this@EditActivity, MainActivity::class.java)
            intent.putExtra("employee", employee)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
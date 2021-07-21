package com.akp.my_students_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.noahgreenmusic.my_students_app.databinding.ActivityStudentAddBinding
import com.akp.my_students_app.models.Student
import com.akp.my_students_app.ui.MainViewModel

class StudentAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentAddBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //instantiating viewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

         binding.buttonAdd.setOnClickListener {
            addStudent()
         }
    }

    private fun addStudent(){
        val name = binding.studentName.text.toString()
        val seat = binding.studentNumber.text.toString()
        val className = binding.classNumber.text.toString()

        if (name.isNotEmpty() && seat.isNotEmpty() && className.isNotEmpty()) {
            val newStudent = Student(name, seat, className)
            viewModel.addStudent(newStudent)
            Toast.makeText(this, "Added Successfully", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }
}
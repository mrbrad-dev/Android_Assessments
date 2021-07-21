package com.jeniffer.my_students_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jeniffer.my_students_api.StudentAddActivity
import com.noahgreenmusic.my_students_app.databinding.ActivityMainBinding
import com.jeniffer.my_students_app.ui.ItemAdapter
import com.jeniffer.my_students_app.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, StudentAddActivity::class.java)
            startActivity(intent)
        }

        itemAdapter = ItemAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.itemsRecycler.adapter = itemAdapter

        viewModel.getItems()
        viewModel.itemsLiveData.observe(this, { items ->
            itemAdapter.items = items
            itemAdapter.notifyDataSetChanged()
        })
    }
}
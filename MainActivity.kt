package com.example.work_with_array_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.work_with_array_adapter.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var data_adapter : ArrayAdapter<String>

    private lateinit var ready_data : MutableList<String>
    private lateinit var data_names : Array<String>
    private lateinit var data_surnames : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data_names = getResources().getStringArray(R.array.names) ?: arrayOf("")
        data_surnames = getResources().getStringArray(R.array.surnames) ?: arrayOf("")

        ready_data = mutableListOf()

        for (i in 0 until 5){
            val temp = data_names[Random.nextInt(data_names.size)] + ' ' + data_surnames[Random.nextInt(data_surnames.size)]
            ready_data.add(temp)
        }

        data_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ready_data)

        binding.mainListview.setAdapter(data_adapter)

        binding.mainBtnAddPeople.setOnClickListener {
            val temp = data_names[Random.nextInt(data_names.size)] + ' ' + data_surnames[Random.nextInt(data_surnames.size)]
            data_adapter.add(temp)
            data_adapter.notifyDataSetChanged()
        }
    }
}
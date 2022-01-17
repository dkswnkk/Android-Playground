package com.example.singlechoicelistview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.singlechoicelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var data1 = arrayOf("항목1","항목2","항목3","항목4","항목5","항목6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,data1)
        binding.listView1.adapter = adapter1
        binding.listView1.choiceMode = binding.listView1.CHOICE_MODE_SINGLE


    }
}
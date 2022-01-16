package com.example.autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.autocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val data1 = arrayOf("abcd", "abca", "abcb", "abcc", "bbab", "bcab", "bdad")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)

        binding.autoCompleteTextView.setAdapter(adapter1)
        binding.button1.setOnClickListener {
            binding.textView1.text = binding.autoCompleteTextView.text
        }
        binding.autoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            binding.textView2.text = "${data1[i]} 항목이 클릭되었습니다."
        }
    }

}
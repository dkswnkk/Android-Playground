package com.example.applicationclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applicationclass.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as AppClass
        binding.textView2.text = app.value2
        binding.button2.setOnClickListener {
            app.value2="안녕히계세요"
            finish()
        }
    }
}
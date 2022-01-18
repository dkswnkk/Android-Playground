package com.example.onactivityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onactivityresult.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.secondButton1.setOnClickListener {
            finish()
        }

    }
}
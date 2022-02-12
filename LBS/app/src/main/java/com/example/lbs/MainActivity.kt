package com.example.lbs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.lbs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SystemClock.sleep(1000)
        setTheme(R.style.Theme_LBS)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
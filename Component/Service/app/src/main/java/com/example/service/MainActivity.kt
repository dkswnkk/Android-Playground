package com.example.service

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val serviceIntent = Intent(this, TestService::class.java)
        binding.button.setOnClickListener {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                startForegroundService(serviceIntent)
            }
            else{
                startService(serviceIntent)
            }

        }

        binding.button2.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}
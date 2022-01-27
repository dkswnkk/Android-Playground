package com.example.activityanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
//            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in)
        }
    }
}
package com.example.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityobject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener {
            val second_intent = Intent(this,SecondActivity::class.java)
            val t1 = TestClass()
            t1.data1 = 100
            t1.data2 = "흠"
            second_intent.putExtra("data1",t1)
            startActivity(second_intent)
        }
    }
}
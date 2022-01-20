package com.example.activityobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activityobject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val obj1 = intent.getParcelableExtra<TestClass>("data1")


        binding.secondButton1.setOnClickListener {
            Log.d("test1","${obj1!!.data1}")
            finish()

        }
    }
}
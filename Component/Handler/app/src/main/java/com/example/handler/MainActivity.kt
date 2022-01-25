package com.example.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import android.os.Looper
import android.os.SystemClock
import android.util.Log
import com.example.handler.databinding.ActivityMainBinding
import java.util.logging.Handler
import java.util.logging.LogRecord
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "${now}"
        }

        val handler = android.os.Handler(Looper.myLooper()!!)

        //처리 한번에 대한 작업을 구현해 준다.
        val thread1 = object:Thread(){
            override fun run() {
                super.run()
                val now2 = System.currentTimeMillis()
                binding.textView2.text="handler: ${now2}"
                handler.postDelayed(this,1000)
            }
        }

       // handler.post(thread1)
        handler.postDelayed(thread1,1000)

//        thread {
//            while(true) {
//                SystemClock.sleep(100)
//                val now2 = System.currentTimeMillis()
//                binding.textView2.text = "${now2}"
//            }
//        }
//        while (true) {
//            SystemClock.sleep(1000)
//            val now2 = System.currentTimeMillis()
//            binding.textView2.text = "${now2}"
//        }



    }
}
package com.example.runonuithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.example.runonuithread.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "버튼 클릭: ${now}"
        }

        isRunning = true
        thread {
            while (isRunning) {
                SystemClock.sleep(500)
                val now2 = System.currentTimeMillis()
                Log.d("test", "${now2}")
//                runOnUiThread(object:Thread(){
//                    override fun run() {
//                        super.run()
//                        binding.textView2.text="${now2}"
//                    }
//                })
                runOnUiThread {
                    binding.textView2.text = "${now2}"
                }
                SystemClock.sleep(500)
//                runOnUiThread(object : Thread() {
//                    override fun run() {
//                        super.run()
//                        binding.textView2.text = "또 다른 작업"
//                    }
//                })
                runOnUiThread {
                    binding.textView2.text = "또 다른 작업"
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}
package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.example.thread.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    // 메인 쓰레드가 바쁘면 화면에 UI 작업이 일어나지 않는다.
    lateinit var binding: ActivityMainBinding
    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "${now}"
        }
        /*
        오래 걸리는 작업은 Thread로 빼야함
         */
//        while(true){
//            SystemClock.sleep(1000)  // 이 시간만큼 쉬었다가 코드 진행
//            val now2 = System.currentTimeMillis()
//            Log.d("test1","${now2}")
//        }

        isRunning = true
//        val thread1 = object : Thread() {
//            override fun run() {
//                super.run()
//
//                while (isRunning) {
//                    SystemClock.sleep(100)
//                    val now2 = System.currentTimeMillis()
//                    Log.d("test1", "${now2}")
//                    binding.textView2.text = "${now2}"
//                }
//            }
//        }
//        thread1.start()
        thread {
            while(isRunning){
                SystemClock.sleep(100)
                val now2 = System.currentTimeMillis()
                Log.d("test1","${now2}")
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}
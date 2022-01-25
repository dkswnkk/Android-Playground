package com.example.handlermessage

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.handlermessage.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "${now}"
        }

        val handler1 = object: Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when(msg.what){
                    0->{
                        binding.textView2.text ="0"
                    }
                    1->{
                        binding.textView2.text="1"
                    }
                    2->{
                        binding.textView2.text = "${msg.arg1}"
                    }
                }
            }
        }
        // 오래 걸리는 작업 - 쓰레드를 발생시켜서 처리
        isRunning = true

        thread {
            while(isRunning){
                val now2 = System.currentTimeMillis()
                Log.d("test","오래 걸리는 작업: ${now2}")
                handler1.sendEmptyMessage(1)
                SystemClock.sleep(500)
                handler1.sendEmptyMessage(0)
                SystemClock.sleep(500)

                val msg = Message()
                msg.what=2
                msg.arg1=1000
                msg.arg2=10000

                handler1.sendMessage(msg)
                SystemClock.sleep(500)
            }
        }

    }

//    override fun onDestroy() {
//        super.onDestroy()
//        isRunning = false
//    }
}
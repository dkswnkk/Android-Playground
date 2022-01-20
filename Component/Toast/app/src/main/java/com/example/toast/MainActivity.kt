package com.example.toast

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.toast.databinding.ActivityMainBinding
import com.example.toast.databinding.CostumToastBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toastBinding: CostumToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        toastBinding = CostumToastBinding.inflate(layoutInflater)
        setContentView(toastBinding.root)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            //Toast 객체를 생성한다.
            val t1 = Toast.makeText(this, "기본 토스트입니다.", Toast.LENGTH_SHORT)
            // callback 객체 생성
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val callback =
                    object : Toast.Callback() {
                        override fun onToastHidden() {
                            super.onToastHidden()
                            binding.textView1.text = "토스트 메세지가 사라졌습니다."
                        }

                        override fun onToastShown() {
                            super.onToastShown()
                            binding.textView1.text = "토스트 메세지가 나타났습니다."
                        }
                    }

                t1.addCallback(callback)
            }
            t1.show()
        }
        binding.button2.setOnClickListener {
            //Toast에 보여줄 View를 생성한다.
            val toastView = layoutInflater.inflate(R.layout.costum_toast, null)
            toastView.run {
                toastBinding.toastTextView1.text = "12312312312?"
            }
            toastView.setBackgroundResource(android.R.drawable.arrow_up_float)
            //Toast 객체를 생선한다.
            val t2 = Toast(this)
            t2.setGravity(Gravity.CENTER, 0, 100)
            t2.duration = Toast.LENGTH_SHORT
            t2.view = toastView
            t2.show()
        }

    }
}
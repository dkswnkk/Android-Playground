package com.example.xmlview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.xmlview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sub1 = layoutInflater.inflate(R.layout.layout_sub1,null)
        val sub2 = layoutInflater.inflate(R.layout.layout_sub2,null)

        //addView를 하지 않아도 자동으로 추가됨 (제거도 되지 않음)
       layoutInflater.inflate(R.layout.layout_sub3,binding.container)

        sub1.run {
            val sub1Button = findViewById<Button>(R.id.sub1_button)
            val sub1Text = findViewById<TextView>(R.id.sub1_text)
            sub1Button.setOnClickListener {
                sub1Text.text = "sub1의 버튼을 눌렸습니다."
                binding.textView.text="sub1의 버튼을 눌렸습니다."
            }
        }

        binding.button.setOnClickListener {
            binding.container.addView(sub1)
            binding.container.addView(sub2)
        }
        binding.button2.setOnClickListener {
            binding.container.removeView(sub1)
            binding.container.removeView(sub2)
        }
    }
}
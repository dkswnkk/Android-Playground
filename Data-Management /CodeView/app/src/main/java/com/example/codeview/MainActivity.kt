package com.example.codeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.codeview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val param1 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, //가로
            LinearLayout.LayoutParams.WRAP_CONTENT, //세로
        )

        val button1 = Button(this)
        button1.text ="추가 된 버튼입니다"
        button1.layoutParams = param1
        button1.setOnClickListener {
            binding.textView.text="추가 된 버튼을 눌렸습니다."
        }

        val image1 = ImageView(this)
        image1.setImageResource(R.mipmap.ic_launcher)
        image1.layoutParams = param1
        binding.button.setOnClickListener {
            binding.container.addView(button1)
            binding.container.addView(image1)
        }

        binding.button2.setOnClickListener {
            binding.container.removeView(button1)
            binding.container.removeView(image1)
        }
    }
}
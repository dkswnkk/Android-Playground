package com.example.imageanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 애니메이션 객체를 추출한다.
        val ani = binding.imageView.drawable as AnimationDrawable

        binding.button.setOnClickListener {
            ani.start()
        }
        binding.button2.setOnClickListener {
            ani.stop()
        }
    }
}
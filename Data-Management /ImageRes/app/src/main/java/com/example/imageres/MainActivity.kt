package com.example.imageres

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.BitmapFactory.decodeResource
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageres.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView2.setImageResource(R.drawable.img_android)


        // Bitmap : JPG,PNG, GIF 파일로 부터 읽어온 이미지 데이터를 관리
        val bitmap = decodeResource(resources,R.drawable.img_android)
        binding.imageView3.setImageBitmap(bitmap)

        // Drawable: Bitmap을  포함한 다양한 타입으로 부터 이미지 데이터를 관리
        val drawable = getDrawable(R.drawable.img_android)
        binding.imageView4.setImageDrawable(drawable)

        // 배경 타일 이미지를 생성한다.
        binding.container.setBackgroundResource(R.drawable.tile)


        // layer 이미지를 사용한다.
        val drawable3 = getDrawable(R.drawable.layer)
        binding.imageView4.setImageDrawable(drawable3)
    }
}
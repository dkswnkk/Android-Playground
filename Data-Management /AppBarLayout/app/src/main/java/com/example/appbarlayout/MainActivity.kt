package com.example.appbarlayout

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.example.appbarlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.toolbarLayout.setExpandedTitleColor(Color.WHITE)
        binding.toolbarLayout.setCollapsedTitleTextColor(Color.RED)


        binding.toolbarLayout.collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
        binding.toolbarLayout.expandedTitleGravity = Gravity.CENTER_VERTICAL

        binding.imageView.setImageResource(R.drawable.imgflag8)
        supportActionBar?.setTitle("zz")
    }
}
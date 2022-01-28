package com.example.actionbarcustomizing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.actionbarcustomizing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // layout을 통해 View를 설정한다.
        var topBar = layoutInflater.inflate(R.layout.custom_actionbar,null)
        supportActionBar?.setDisplayShowCustomEnabled(true)

        // 옛날 os에서는 작동을 안할 수도 있어서 추가해준다.
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        supportActionBar?.customView = topBar

        topBar.run{
            var actionBarText = findViewById<TextView>(R.id.actionbar_text)
            actionBarText.text = "액션바 타이틀"
        }

    }
}
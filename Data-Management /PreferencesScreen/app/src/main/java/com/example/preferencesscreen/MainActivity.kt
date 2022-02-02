package com.example.preferencesscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.preferencesscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val settingFragment = SettingFragment()
    val resultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, settingFragment)
                .commit()
        }
        binding.button2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, resultFragment)
                .commit()
        }
    }
}
package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subFragment = SubFragment()
        val tran = supportFragmentManager.beginTransaction().replace(R.id.container1,subFragment).commit()

    }
}
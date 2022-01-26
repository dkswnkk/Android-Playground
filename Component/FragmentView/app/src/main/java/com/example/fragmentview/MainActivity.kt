package com.example.fragmentview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val frag1 = SubFragment()
        val tran = supportFragmentManager.beginTransaction().replace(R.id.container1, frag1)
        tran.commit()

    }
}
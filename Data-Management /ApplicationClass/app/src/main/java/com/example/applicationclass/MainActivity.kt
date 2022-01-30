package com.example.applicationclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applicationclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val app = application as AppClass
            app.method1()
            app.value1=100
            app.value2="안녕하세요"
            val secondIntent = Intent(this, SecondActivity::class.java)
            startActivityForResult(secondIntent,0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val app = application as AppClass
        when(resultCode){
            0->{
                binding.textView.text=app.value2
            }
        }
    }
}
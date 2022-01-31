package com.example.assets

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assets.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val inputStream = assets.open("text/data1.txt")
            val isr = InputStreamReader(inputStream,"UTF-8")
            val br = BufferedReader(isr)

            var str:String?=null
            val sb = StringBuffer()

            while(true){
                str = br.readLine()
                if(str==null) break
                sb.append("${str}\n")
            }
            br.close()
            binding.textView.text = sb
        }

        binding.button2.setOnClickListener {
            val face = Typeface.createFromAsset(assets,"font/Dongle-Bold.ttf")
            binding.textView.typeface = face
        }
    }
}
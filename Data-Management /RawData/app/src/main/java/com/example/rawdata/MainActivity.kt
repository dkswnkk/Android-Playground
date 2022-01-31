package com.example.rawdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rawdata.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val inputStream = resources.openRawResource(R.raw.data1)
            val isr = InputStreamReader(inputStream, "UTF-8")
            var br = BufferedReader(isr)

            var str: String? = null
            var sb = StringBuffer()

            do {
                str = br.readLine()
                if (str != null) sb.append("${str}\n")
            } while (str != null)
            br.close()

            binding.textView.text= sb.toString()
        }
    }
}
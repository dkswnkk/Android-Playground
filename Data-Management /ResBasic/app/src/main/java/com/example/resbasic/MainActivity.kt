package com.example.resbasic

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.resbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
//            binding.textView.text = "반갑습니다."
            binding.textView.setText(R.string.str2)
            val str2 = resources.getString(R.string.str2)
            Log.d("test", str2)
        }
        binding.button2.setOnClickListener {
            val str3 = String.format(getString(R.string.str3), "안주형", 25)
            binding.textView.text = str3
        }
        binding.button3.setOnClickListener {
            val data_list = resources.getStringArray(R.array.data_array)
            binding.textView.text=""
            for(inp in data_list){
                binding.textView.append("${inp}\n")
            }
        }
        binding.button4.setOnClickListener {
//            binding.textView.setTextColor(Color.RED)
//            binding.textView.setTextColor(Color.rgb(26,100,100))
            binding.textView.setTextColor(getColor(R.color.color1))
        }

        binding.button5.setOnClickListener {
            val px = resources.getDimension(R.dimen.px)
            val dp = resources.getDimension(R.dimen.dp)
            val sp = resources.getDimension(R.dimen.sp)
            val inch = resources.getDimension(R.dimen.inch)
            val mm = resources.getDimension(R.dimen.mm)
            val pt = resources.getDimension(R.dimen.pt)

            binding.textView.text = ""
            binding.textView.append("px: ${px}\n")
            binding.textView.append("dp: ${dp}\n")
            binding.textView.append("sp: ${sp}\n")
            binding.textView.append("inch: ${inch}\n")
            binding.textView.append("pt: ${pt}\n")


        }
    }
}
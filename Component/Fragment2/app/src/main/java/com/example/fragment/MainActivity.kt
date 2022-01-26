package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frag1 = FirstFragment()
        val frag2 = SecondFragment()

        binding.button.setOnClickListener {
            // Fragment 작업 시작
            val tran = supportFragmentManager.beginTransaction()
            tran.addToBackStack(null)   // Fragment로 Activity 취급하여 백버튼시 사라짐
            // Fragment를 셋팅한다.
            tran.replace(R.id.container1,frag1)
            tran.commit()
        }
        binding.button2.setOnClickListener {
            val tran  = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container1,frag2)
            tran.commit()
        }

    }
}
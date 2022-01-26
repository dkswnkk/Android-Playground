package com.example.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentlifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val frag1 = SubFragment()

        binding.button.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction().replace(R.id.container1, frag1)
            // 백버튼을 추가하면 Stop까지만 생성된다.
//            tran.addToBackStack(null)
            tran.commit()
        }
        binding.button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction().remove(frag1)
            tran.commit()
        }

    }
}
package com.example.onactivityresult

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onactivityresult.databinding.ActivityThirdBinding

lateinit var binding:  ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.thirdButton1.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
        binding.thirdButton2.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        binding.thirdButton3.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
        binding.thirdButton4.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER+1)
            finish()
        }

    }
}
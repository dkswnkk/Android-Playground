package com.example.activityanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityanimation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.secondButton1.setOnClickListener {
            finishActivity()
        }
    }
    // BackButton을 누르면 호출되는 메서드

    override fun onBackPressed() {
//        super.onBackPressed()   //지우면 뒤로가기 버튼이 반응하지 않
        finishActivity()
    }

    fun finishActivity() {
        finish()    //Activity 종료
//        overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in)
    }
}

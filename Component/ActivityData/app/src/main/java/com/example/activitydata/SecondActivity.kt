package com.example.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitydata.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //현재 액티비티를 실행하기 위해 사용한 인텐트 부터 데아터를 추출한다.
        var data1 = intent.getIntExtra("data1",0)
        var data2 = intent.getIntExtra("data2",0)

        binding.secondTextView1.text=data1.toString()

        binding.secondButton1.setOnClickListener {
            var result_intent = Intent()

            result_intent.putExtra("data1",data1+100)
            result_intent.putExtra("data2",data2+100)

            setResult(RESULT_OK,result_intent)
            finish()
        }
    }
}
package com.example.rotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rotation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState==null){
            Log.d("test","Activity가 처음 등장 하였습니다.")
        }
        else{
            Log.d("test","화면 회전이 발생했습니다.")
            binding.textView.text = savedInstanceState.getString("data1")
        }

        binding.button.setOnClickListener {
            binding.textView.text = binding.editTextTextPersonName.text
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 복원에 필요한 데이터를 저장한다.
        outState.putString("data1",binding.textView.text.toString())
    }
}
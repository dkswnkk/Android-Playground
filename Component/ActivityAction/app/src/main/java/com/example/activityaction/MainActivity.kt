package com.example.activityaction

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityaction.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    val permission_list = arrayOf(
        android.Manifest.permission.CALL_PHONE
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        requestPermissions(permission_list,0)

        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val uri = Uri.parse("geo:37.243243,131.861010")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val uri = Uri.parse("https://www.naver.com")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_DIAL,uri)
            startActivity(intent)
        }
        // 전화 걸기 같은경우에는 권한을 등록하여 사용자의 동의를 얻어야만 가능하다.
        // 그렇지 않을 시 오류가 뜬다.
        binding.button4.setOnClickListener {
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_CALL,uri)
            startActivity(intent)

        }
    }
}
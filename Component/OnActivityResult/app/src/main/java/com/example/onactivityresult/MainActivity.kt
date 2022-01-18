package com.example.onactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.onactivityresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener {
            startActivityForResult(Intent(this,SecondActivity::class.java),1)
        }
        binding.button2.setOnClickListener {
            startActivityForResult(Intent(this,ThirdActivity::class.java),2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        Log.d("test1","다른 액티비티에서 돌아왔을때 ")

        when(requestCode){
            1->{
                binding.textView1.text = "2액티비티에서 돌아옴"
            }
            2->{
                binding.textView1.text="3액티비티에서 돌아옴\n"
                when(resultCode){
                    Activity.RESULT_OK->{
                        binding.textView1.append("OK")
                    }
                    Activity.RESULT_CANCELED->{
                        binding.textView1.append("CANCLED")
                    }
                    Activity.RESULT_FIRST_USER->{
                        binding.textView1.append("FIRST_USER")
                    }
                    Activity.RESULT_FIRST_USER+1->{
                        binding.textView1.append("FIST_USER+1")
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
package com.example.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitydata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding  = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener {
            val second_Intent = Intent(this,SecondActivity::class.java)
            second_Intent.putExtra("data1",100)
            second_Intent.putExtra("data2",200)
//            startActivity(second_Intent)
            startActivityForResult(second_Intent,0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==0){
            if(resultCode== RESULT_OK){
                Log.d("test11","${data?.getIntExtra("data1",0)}")
//                print(data?.getIntExtra("data1",0))
            }
        }
    }


}
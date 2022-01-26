package com.example.activitycontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitycontroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val inputFragment = InputFragment()
    val resultFragment = ResultFragment()

    // fragment들이 사용할 변수
    var value1 = "123"
    var value2 = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment("inputFragment")
    }

    fun setFragment(name: String){
        val tran =supportFragmentManager.beginTransaction()
        when(name){
            "inputFragment"->{
                tran.replace(R.id.container1,inputFragment).commit()
            }
            "resultFragment"->{
                tran.replace(R.id.container1,resultFragment).addToBackStack(null).commit()

            }

        }
    }

}
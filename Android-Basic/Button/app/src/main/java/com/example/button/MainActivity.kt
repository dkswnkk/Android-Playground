package com.example.button

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {ㄹ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(listener1)
        button2.setOnClickListener(listner3)
        button3.setOnClickListener(listner3)
        imagebutton1.setOnClickListener(listner2)
        button4.setOnClickListener {
            text1.text="다섯번째 버튼을 눌렸음"
        }
    }

    val listener1 = object: View.OnClickListener{
        override fun onClick(p0: View?) {
            text1.text="첫 번째 버튼을 눌렸음"
        }
    }
    val listner2 = object:View.OnClickListener{
        override fun onClick(p0: View?) {
            text1.text="두 번째 버튼을 눌렸음"
        }
    }
    val listner3 = object:View.OnClickListener{
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.button2->{
                    text1.text="세 번째 버튼을 눌렸음"
                }
                R.id.button3->{
                    text1.text="네 번째 버튼을 눌렸"
                }
            }
        }
    }

}
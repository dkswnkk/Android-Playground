package com.example.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            textView1.text ="Y: ${scrollView1.scrollY}"
            textView2.text ="X: ${scrollView2.scrollX}"
        }
        button2.setOnClickListener {
            //  지정 된 위치로 애니메이션 없이 이동
//            scrollView1.scrollTo(0,1000)
//            scrollView2.scrollTo(1000,0)
            // 지정 된 위치로 애니메이션과 함께 이동
//            scrollView1.smoothScrollTo(0,1000)
//            scrollView2.smoothScrollTo(1000,0)
            // 현재 위치에서 지정된 만큼 애니메이션과 함께 이
              scrollView1.smoothScrollBy(0,1000)
              scrollView2.smoothScrollBy(1000,0)
        }
        scrollView1.setOnScrollChangeListener(listner1)
    }


    val listner1 = object:View.OnScrollChangeListener{
        override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {
          when(p0?.id){
              R.id.scrollView1->{
                  textView1.text="Y: ${p4} -> ${p2}"
              }
          }
        }
    }
}
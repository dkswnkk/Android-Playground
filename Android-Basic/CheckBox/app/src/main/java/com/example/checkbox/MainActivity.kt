package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            textView1.text=""
            if(checkBox1.isChecked){
                textView1.text ="텍스트 박스가 클릭되어있음"
            }
            else{
                textView1.text="텍스트 박스가 클릭되어 있지 않음"
            }
        }

        checkBox1.setOnCheckedChangeListener(listner1)

//        checkBox2.setOnCheckedChangeListener {
//                compoundButton: CompoundButton, b: Boolean ->
//            textView1.text="체크박스2 상태가 변경됨"
//        }
        button2.setOnClickListener {
            checkBox1.isChecked=true
            checkBox2.isChecked=true
            checkBox3.isChecked=true
        }
        button3.setOnClickListener {
            checkBox1.isChecked=false
            checkBox2.isChecked=false
            checkBox3.isChecked=false
        }
        button4.setOnClickListener {
            checkBox1.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }

    }
    val listner1  = object: CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            when(p0?.id){
                R.id.checkBox1->{
                    if(checkBox1.isChecked){
                        textView1.text="첫 번째 체크박스가 체크되었습니다."
                    }
                    else{
                        textView1.text="첫 번째 체크박스가 해제되었습니다."
                    }
                }
            }
        }
    }
}
package com.example.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
            radioButton3.isChecked=true
            radioButton6.isChecked=true

        }
        button2.setOnClickListener {
            when(radioGroup1.checkedRadioButtonId) {
                R.id.radioButton1 -> {
                    textView1.text = "라디오 1-1이 체크되어 있습니다."
                }
                R.id.radioButton2 -> {
                    textView1.text = "라디오 1-2이 체크되어 있습니다."
                }
                R.id.radioButton3 -> {
                    textView1.text = "라디오 1-3이 체크되어 있습니다."
                }
            }
            when(radioGroup2.checkedRadioButtonId){
                R.id.radioButton4 ->{
                    textView2.text="라디오 2-1이 체크되어 있습니다."
                }
                R.id.radioButton5->{
                    textView2.text="라디오 2-2이 체크되어 있습니다."
                }
                R.id.radioButton6->{
                    textView2.text="라디오 2-3이 체크되어 있습니다."
                }

            }
        }
        radioGroup1.setOnCheckedChangeListener(listner1)
        radioGroup2.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radioButton4->{
                    textView1.text="라디오 2-1이 체크되었습니다."
                }
                R.id.radioButton5->{
                    textView1.text="라디오 2-2이 체크되었습니다."
                }
                R.id.radioButton6->{
                    textView1.text="라디오 2-3이 체크되었습니다."
                }
            }
        }
    }
    val listner1  = object:RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
           when(p0?.id){
               R.id.radioGroup1->{
                   when(p1){
                       R.id.radioButton1->{
                           textView1.text="라디오 1-1이 체크되었습니다."
                       }
                       R.id.radioButton2->{
                           textView1.text="라디오 1-2가 체크되었습니다."
                       }
                       R.id.radioButton3->{
                           textView1.text="라디오 1-3이 체크되었습니다."
                       }
                   }
               }
           }
        }
    }
}
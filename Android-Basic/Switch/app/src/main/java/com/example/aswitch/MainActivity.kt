package com.example.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
           if(switch1.isChecked){
               textView1.text ="ON상태입니다."
           }
            else{
                textView1.text ="OFF상태입니다."
           }
        }

        button2.setOnClickListener {
            switch1.isChecked=true
        }
        button3.setOnClickListener {
            switch1.isChecked=false
        }
        switch1.setOnCheckedChangeListener(listner1)
        switch2.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                textView2.text = "두 번째 스위치가 온 상태입니다."
            }
            else{
                textView2.text = "두 번째 스위치가 오프 상태입니다."
            }
        }
    }

    val listner1 = object: CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            when(p0?.id) {
                R.id.switch1 -> {
                    if (p1) {
                        textView1.text = "첫 번째 스위치가 온 상태입니다."
                    } else {
                        textView1.text = "첫 번째 스위치가 오프 상태입니다."
                    }
                }
            }
        }
    }
}
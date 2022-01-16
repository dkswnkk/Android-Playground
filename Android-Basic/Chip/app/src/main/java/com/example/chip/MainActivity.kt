package com.example.chip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chip1.setOnClickListener {
            textView1.text = " 첫 번째 Chip을 클릭하였습니다\n"
            if (chip2.isChecked) {
                textView1.append("두 번째 칩이 선택되어 있습니다.\n")
            } else {
                textView1.append("두 번째 칩이 선택되어 있지 않습니다.\n")
            }
            if (chip3.isChecked) {
                textView1.append("세 번째 칩도 선택\n")
            } else {
                textView1.append("세 번째 칩은 선ㄴ택 x\n")
            }
            if (chip4.isChecked) {
                textView1.append("네 번째 칩이 선택 됨\n")
            } else {
                textView1.append("네 번째 칩 선택 x\n")
            }
            when(chipGroup1.checkedChipId){
                R.id.chip5->{
                    textView1.append("그룹 내의 첫 번번쨰 칩이 선택 됨\n")
                }
                R.id.chip6->{
                    textView1.append("그룹 내의 두 번째 칩이 선택 됨\n")
                }
                R.id.chip7->{
                    textView1.append("그룹 냉,ㅢ 세 번째 칩이 선택 됨\n")
                }

            }
        }
        chip3.setOnClickListener {
            textView1.text = "세 번쨰 Chip을 클릭했습니다."
        }
        chip3.setOnCloseIconClickListener {
            textView1.text =" 닫기 버튼을 눌림"
        }
        chip4.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
               textView1.text = "네 번쨰 칩이 선택 됨\n"
            }
            else{
                textView1.text="네 번쨰 칩이 선택 되지 않음"
            }
        }

        }
    }

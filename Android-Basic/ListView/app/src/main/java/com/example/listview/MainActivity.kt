package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("문자열1","문자열2","문자열3","문자열4","문자열5","문자열6","문자열7","문자열8","문자열9","문자열10","문자열11","문자열12","문자열13","문자열14","문자열15")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //첫번째: Contest
        //두번째: 항목 하나를 구성하기 위해ㅐ 사용 할 Layout 파일

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1, data1)
        listView1.adapter=adapter1

        listView1.setOnItemClickListener(listner1)

    }
    val listner1 = object:AdapterView.OnItemClickListener{
        // 첫 번째: 이벤트가 발생한 항목을 가지고 있는 AdapterView
        // 두 번쨰: 이벤트가 발생한 항목 View
        // 세 번째: 이벤트가 발생한 항목의 index
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when(p0?.id){
                R.id.listView1->{
                    textView.text  = (p2+1).toString()+" 번째 항목을 클릭했습니다."

                }
            }
        }
    }
}
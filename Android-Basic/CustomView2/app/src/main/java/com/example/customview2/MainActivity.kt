package com.example.customview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val imgRes = intArrayOf(R.drawable.imgflag1,R.drawable.imgflag2,
        R.drawable.imgflag3,R.drawable.imgflag4,
        R.drawable.imgflag5,R.drawable.imgflag6,
        R.drawable.imgflag7,R.drawable.imgflag8)

    val data1 = arrayOf("토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국")
    val data2 = arrayOf("togo","france","swiss","spain","japan","german","brazil","korea")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //simple adapter에 셋팅할 데이터를 가지고 있을 ArrayList

        val dataList = ArrayList<HashMap<String,Any>>()

        for(i in imgRes.indices){
            //항목 하나를 구성하기 위해 필요한 데이터를 담고 있는 HashMap
            val map = HashMap<String,Any>()
            map["img"] = imgRes[i]
            map["data1"] = data1[i]
            map["data2"] = data2[i]
            dataList.add(map)
        }
        //  HashMap에 데이터를 저장했을 때 사용했던 이름 배열
        val keys = arrayOf("img","data1","data2")
        //  데이터를 세팅 할 View의 id 배열
        val ids = intArrayOf(R.id.rowImageView1,R.id.rowTextView1,R.id.rowTextView2)
        val adapter1  = SimpleAdapter(this,dataList, R.layout.row,keys,ids)
        listView1.adapter = adapter1

        listView1.setOnItemClickListener { adapterView, view, i, l ->
            textView1.text = dataList[i].get("data1").toString()
        }
    }
}
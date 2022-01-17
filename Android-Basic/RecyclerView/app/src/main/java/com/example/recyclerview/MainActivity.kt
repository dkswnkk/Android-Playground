package com.example.recyclerview

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.RowBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var row: RowBinding

    var imgRes = intArrayOf(
        R.drawable.imgflag1,R.drawable.imgflag2,R.drawable.imgflag3,R.drawable.imgflag4,
        R.drawable.imgflag5,R.drawable.imgflag6,R.drawable.imgflag7,
    )
    var data1 = arrayOf("토고","프랑스","스위스","스페인","일본","독일","대한민국")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        row = RowBinding.inflate(layoutInflater)

        val rowView = row.root
        val view = binding.root
        setContentView(view)
        setContentView(rowView)


        binding.recyclerView1.adapter = RecyclerAdapter()
        binding.recyclerView1.layoutManager = LinearLayoutManager(this)

    }
    //RecyclerView의 Adater 클래스
    inner class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {
        override fun getItemCount(): Int {
            return imgRes.size
        }

        // ViewHolder를 통해 항목을 구성할 때 항목 내의 View 객체에 데이터를 셋팅한다.
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextview.text = data1[position]
        }

        // 항목 구성을 위해 사용할 View Holder 객체가 필요할 때 호출되는 메서드
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            //항목으로 사용할 View 객체를 생성한다.
            val itemView = layoutInflater.inflate(R.layout.row,null)
            return ViewHolderClass(itemView)
        }

        //ViewHolder 클래스
        inner class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
            //항목 View 내부의 View 객체의 주소값을 담는다.
            val rowImageView = itemView1.row
            val rowTextview = row.rowTextView1
        }
    }
}